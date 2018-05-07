/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.teamplayer.player;

import com.google.gson.Gson;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import teamdaoapp.model.Player;
import teamdaoapp.model.Model;

/**
 * Service of player application
 *
 * @author dmora
 */
@Path("/player-service")
public class PlayerService {

    /**
     * data model to provide data access.
     */
    private final Model model;

    /**
     * Constructor. It gets a reference to the model and saves it in the
     * application context to
     *
     * @param context the application context
     */
    public PlayerService(@Context ServletContext context) {
        if (context.getAttribute("model") != null) {
            model = (Model) context.getAttribute("model");
        } else {
            model = new Model();
            context.setAttribute("model", model);
        }
    }

    /**
     * gets all players
     *
     * @return list of players in json
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchAll() {
        return new Gson().toJson(model.findAllPlayers());
    }

    /**
     * Find player by id
     *
     * @param id to search for
     * @return player or code 0 Player Not Found
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchById(@PathParam("id") long id) {
        Player p = model.find(new Player(id));
        if (p == null) {
            return new Gson().toJson("not found");
        } else {
            return new Gson().toJson(p);
        }
    }

    /**
     * Find player by name
     *
     * @param name to search for
     * @return player or code 0 Player Not Found
     */
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchPlayerByName(@PathParam("name") String name) {
        List<Player> resultList = model.findPlayersByName(name);
        if (resultList == null) {
            return new Gson().toJson("notfound");
        } else {
            return new Gson().toJson(resultList);
        }
    }

    /**
     * Find player by team
     *
     * @param teamId to search for
     * @return player or code 0 Player Not Found
     */
    @GET
    @Path("/players/{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchPlayerByTeam(@PathParam("teamId") long teamId) {
        List<Player> resultList = model.findPlayersByTeamId(teamId);
        if (resultList == null) {
            return new Gson().toJson("notfound");
        } else {
            return new Gson().toJson(resultList);
        }
    }

    /**
     * Add a new player
     *
     * @param id
     * @param name
     * @param yearBirth
     * @param teamId
     * @return 1 ok , 0 fail
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(
            @FormParam("id") long id,
            @FormParam("name") String name,
            @FormParam("yearBirth") int yearBirth,
            @FormParam("teamId") long teamId) {
        Player p = new Player(id, name, yearBirth, teamId);
        if (model.add(p) == 1) {
            return new Gson().toJson("ok");
        } else {
            return new Gson().toJson("fail");
        }
    }

    /**
     * Modify a player
     *
     * @param oldid
     * @param id
     * @param name
     * @param yearBirth
     * @param teamId
     * 
     * @return 1 ok , 0 fail
     */
    @POST
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String modify(
            @PathParam("id") long oldid,
            @FormParam("id") long id,
            @FormParam("name") String name,
            @FormParam("yearBirth") int yearBirth,
            @FormParam("teamId") long teamId) {
        if (model.modify(
                new Player(oldid, name, yearBirth, teamId),
                new Player(id, name, yearBirth, teamId)
        ) == 1) {
            return new Gson().toJson("ok");
        } else {
            return new Gson().toJson("fail");
        }
    }

    /**
     * Remove a player
     *
     * @param id of player to remove
     * @return 1 ok , 0 fail
     *
     */
    @POST
    @Path("/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(@PathParam("id") long id) {
        Player p = new Player(id, "", 0, 0);
        if (model.remove(p) == 1) {
            return new Gson().toJson("ok");
        } else {
            return new Gson().toJson("fail");
        }
    }

}
