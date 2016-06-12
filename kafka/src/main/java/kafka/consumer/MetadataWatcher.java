package com.test.kafka.consumer;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;

/**
 * Created by liju on 3/27/16.
 */
public class MetadataWatcher implements Watcher {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MetaDataConsumer.class);

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("watcher event", watchedEvent.getType().toString());
    }
}
