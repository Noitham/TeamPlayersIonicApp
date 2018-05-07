/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmora
 */
package com.dmora.teamplayer;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Services application config
 *
 * @ApplicationPath determines base url for all controllers.
 * @author dmora
 */
@ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        //resources.add(com.dmora.teamplayer.filter.APIKeyCheckRequestFilter.class);
        //resources.add(com.dmora.teamplayer.filter.APIKeyCheckRequestFilter.class);
        resources.add(com.dmora.teamplayer.filter.APIKeyCheckRequestFilter.class);
        resources.add(com.dmora.teamplayer.player.PlayerService.class);
        resources.add(com.dmora.teamplayer.team.TeamService.class);
    }

}
