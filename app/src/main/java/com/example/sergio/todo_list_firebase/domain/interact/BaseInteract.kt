package com.example.sergio.todo_list_firebase.domain.interact

import com.example.sergio.todo_list_firebase.domain.executor.IPostExecutionThread
import com.example.sergio.todo_list_firebase.domain.executor.IThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).

 * By convention each UseCase implementation will return the result using a [Subscriber]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class BaseInteract<T, E>(private val threadExecutor: IThreadExecutor, private val postExecutionThread: IPostExecutionThread) {
    private var subscription = Subscriptions.empty()

    /**
     * Builds an [Observable] which will be used when executing the current [BaseInteract].
     */
    protected abstract fun buildUseCaseObservable(param: E): Observable<T>

    /**
     * Executes the current use case.

     * @param useCaseSubscriber The guy who will be listen to the observable build
     */
    @SuppressWarnings("unchecked")
    fun execute(param: E, useCaseSubscriber: Subscriber<T>) {
        this.subscription = this.buildUseCaseObservable(param)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber)
    }

    /**
     * Unsubscribes from current [Subscription].
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

}