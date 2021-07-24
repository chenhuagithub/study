package com.maoyan.server;

import com.google.common.collect.ImmutableSet;
import com.maoyan.service.Scribe;
import io.airlift.drift.codec.ThriftCodecManager;
import io.airlift.drift.server.DriftServer;
import io.airlift.drift.server.DriftService;
import io.airlift.drift.server.stats.NullMethodInvocationStatsFactory;
import io.airlift.drift.transport.netty.server.DriftNettyServerConfig;
import io.airlift.drift.transport.netty.server.DriftNettyServerTransportFactory;

import java.util.Optional;

/**
 * @author chenhua11
 * @date 2021/6/26  7:25 下午
 */
public class ServerConfig {
    public static void main(String[] args) {
        // service handler (must be thread safe)
        Scribe service = new Scribe();
    
        DriftNettyServerConfig config = new DriftNettyServerConfig();
        config.setPort(8080);
    
        // create the server
        DriftServer driftServer = new DriftServer(
                new DriftNettyServerTransportFactory(config),
                new ThriftCodecManager(),
                new NullMethodInvocationStatsFactory(),
                ImmutableSet.of(new DriftService(service, Optional.empty(), true)),
                ImmutableSet.of());

        // start the server (it should be shutdown when no longer needed)
        driftServer.start();
    
    }
}