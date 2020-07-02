package com.example.project2;

import androidx.test.espresso.IdlingResource;

public class ElapsedTimeIdlingResource implements IdlingResource {
    public final long startTime;
    public final long waitingTime;
    public ResourceCallback resourceCallback;

    public ElapsedTimeIdlingResource(long waitingTime)
    {
        this.startTime = System.currentTimeMillis();
        this.waitingTime = waitingTime;
    }

    @Override
    public String getName()
    {
        return ElapsedTimeIdlingResource.class.getName() + ":" + waitingTime;
    }

    @Override
    public boolean isIdleNow()
    {
        long elapsed = System.currentTimeMillis() - startTime;
        boolean idle = (elapsed >= waitingTime);
        if(idle)
        {
            resourceCallback.onTransitionToIdle();
        }

        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback)
    {
        this.resourceCallback = resourceCallback;
    }
}
