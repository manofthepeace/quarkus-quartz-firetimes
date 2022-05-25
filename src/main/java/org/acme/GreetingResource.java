package org.acme;

import java.time.Instant;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.Scheduler;

public class GreetingResource {

    @Inject
    Scheduler scheduler;

    @Inject
    Logger log;

    @Scheduled(every = "10s", identity = "test")
    public void hello() {
        Instant pft = scheduler.getScheduledJob("test").getPreviousFireTime();
        Instant nft = scheduler.getScheduledJob("test").getNextFireTime();
        log.infof("Previous Fire time is: %s", pft);
        log.infof("Next Fire time is: %s", nft);
    }
}