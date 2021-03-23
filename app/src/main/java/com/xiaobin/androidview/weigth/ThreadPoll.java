package com.xiaobin.androidview.weigth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * data:2021/3/22
 * Author:renbin
 */
class ThreadPoll {

    public static void main(String[] args) {
        //1 线程池
        creatThreadPoolExecutor();
        //其中有4种线程池比较常用，它们分别是
        //FixedThreadPool、CachedThreadPool、SingleThreadExecutor和ScheduledThreadPool。
        //FixedThreadPool 是可重用固定线程数的线程池
        //CachedThreadPool是一个根据需要创建线程的线程池
        //SingleThreadExecutor是使用单个工作线程的线程池
        //ScheduledThreadPool是一个能实现定时和周期性任务的线程池
    }



    private static void creatThreadPoolExecutor() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,20,5000, TimeUnit.DAYS, new BlockingDeque<Runnable>() {
            @Override
            public void addFirst(Runnable runnable) {

            }

            @Override
            public void addLast(Runnable runnable) {

            }

            @Override
            public boolean offerFirst(Runnable runnable) {
                return false;
            }

            @Override
            public boolean offerLast(Runnable runnable) {
                return false;
            }

            @Override
            public Runnable removeFirst() {
                return null;
            }

            @Override
            public Runnable removeLast() {
                return null;
            }

            @Nullable
            @Override
            public Runnable pollFirst() {
                return null;
            }

            @Nullable
            @Override
            public Runnable pollLast() {
                return null;
            }

            @Override
            public Runnable getFirst() {
                return null;
            }

            @Override
            public Runnable getLast() {
                return null;
            }

            @Nullable
            @Override
            public Runnable peekFirst() {
                return null;
            }

            @Nullable
            @Override
            public Runnable peekLast() {
                return null;
            }

            @Override
            public void putFirst(Runnable runnable) throws InterruptedException {

            }

            @Override
            public void putLast(Runnable runnable) throws InterruptedException {

            }

            @Override
            public boolean offerFirst(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public boolean offerLast(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public Runnable takeFirst() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable takeLast() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public Runnable pollLast(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public boolean removeFirstOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean removeLastOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean add(Runnable runnable) {
                return false;
            }

            @Override
            public boolean offer(Runnable runnable) {
                return false;
            }

            @Override
            public void put(Runnable runnable) throws InterruptedException {

            }

            @Override
            public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public Runnable remove() {
                return null;
            }

            @Override
            public Runnable poll() {
                return null;
            }

            @Override
            public Runnable take() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public int remainingCapacity() {
                return 0;
            }

            @Override
            public Runnable element() {
                return null;
            }

            @Override
            public Runnable peek() {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Runnable> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(@Nullable Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int drainTo(Collection<? super Runnable> c) {
                return 0;
            }

            @Override
            public int drainTo(Collection<? super Runnable> c, int maxElements) {
                return 0;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator<Runnable> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @NonNull
            @Override
            public Iterator<Runnable> descendingIterator() {
                return null;
            }

            @Override
            public void push(Runnable runnable) {

            }

            @Override
            public Runnable pop() {
                return null;
            }
        });

    }

}
