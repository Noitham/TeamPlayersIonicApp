/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.teamplayer.team;

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

import teamdaoapp.model.Team;
import teamdaoapp.model.Player;
import teamdaoapp.model.Model;

/**
 * Service of player application
 *
 * @author dmora
 */
@Path("/team-service")
public class TeamService {

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
    public TeamService(@Context ServletContext context) {
        if (context.getAttribute("model") != null) {
            model = (Model) context.getAttribute("model");
        } else {
            model = new Model();
            context.setAttribute("model", model);
        }
    }

    /**
     * gets all teams
     *
     * @return list of teams in json
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchAll() {
        return new Gson().toJson(model.findAllTeams());
    }

    /**
     * Find team by id
     *
     * @param id to search for
     * @return team or code 0 Team Not Found
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchById(@PathParam("id") long id) {
        Team t = model.find(new Team(id));
        if (t == null) {
            return new Gson().toJson("not found");
        } else {
            return new Gson().toJson(t);
        }
    }

    /**
     * Find team by name
     *
     * @param name to search for
     * @return team or code 0 Team Not Found
     */
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchTeamByName(@PathParam("name") String name) {
        List<Team> resultList = model.findTeamsByName(name);
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
    public String searchPlayersByTeam(@PathParam("teamId") long teamId) {
        List<Player> resultList = model.findPlayersByTeamId(teamId);
        if (resultList == null) {
            return new Gson().toJson("notfound");
        } else {
            return new Gson().toJson(resultList);
        }
    }

    
    /**
     * Add a new Team
     *
     * @param id
     * @param name
     * @param desc
     * @return 1 ok , 0 fail
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(
            @FormParam("id") long id,
            @FormParam("name") String name,
            @FormParam("desc") String desc) {
        Team t = new Team(id, name, desc);
        if (model.add(t) == 1) {
            return new Gson().toJson("ok");
        } else {
            return new Gson().toJson("fail");
        }
    }

    /**
     * Modify a team
     *
     * @param oldid
     * @param id
     * @param name
     * @param desc
     * @return 1 ok , 0 fail
     */
    @POST
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String modify(@PathParam("id") long oldid,
            @FormParam("id") long id,
            @FormParam("name") String name,
            @FormParam("desc") String desc) {
        if (model.modify(
                new Team(oldid, name, desc),
                new Team(id, name, desc)
        ) == 1) {
            return new Gson().toJson("ok");
        } else {
            return new Gson().toJson("fail");
        }
    }

    /**
     * Remove a team
     *
     * @param id of team to remove
     * @return 1 ok , 0 fail
     *
     */
    @POST
    @Path("/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(@PathParam("id") long id) {
        Team t = new Team(id, "", "");
        if (model.remove(t) == 1) {
            return new Gson().toJson("ok");
        } else {
            return new Gson().toJson("fail");
        }
    }

}