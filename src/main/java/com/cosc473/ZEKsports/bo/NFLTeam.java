package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NFLTeam")
public class NFLTeam {

	private String division;
	private String teamName;
	private String teamCity;
	private int overallTeamRank;
	private String divisionTeamRank;
	private String gamesPlayed;
	private String passAttempts;
	private String passCompletions;
	private String passCompletionsPct;
	private String grossPassYards;
	private String netPassYards;
	private String passAverageYards;
	private String passYardsPerAttempt;
	private String passTouchdowns;
	private String passInterceptions;
	private String rushAttempts;
	private String rushYards;
	private String rushAverageYards;
	private String fumbles;
	private String recTouchdowns;
	private String sacks;
	private String tackles;
	private String safeties;
	private String interceptions;
	private String penalties;
	private String offenseYards;
	private String totalTouchDowns;
	private String totalTwoPointConversions;

	public NFLTeam() {
	}

	public NFLTeam(String division, String teamName, String teamCity, int overallTeamRank, String divisionTeamRank,
			String gamesPlayed, String passAttempts, String passCompletions, String passCompletionsPct,
			String grossPassYards, String netPassYards, String passAverageYards, String passYardsPerAttempt,
			String passTouchdowns, String passInterceptions, String rushAttempts, String rushYards,
			String rushAverageYards, String fumbles, String recTouchdowns, String sacks, String tackles,
			String safeties, String interceptions, String penalties, String offenseYards, String totalTouchDowns,
			String totalTwoPointConversions) {
		this.division = division;
		this.teamName = teamName;
		this.teamCity = teamCity;
		this.overallTeamRank = overallTeamRank;
		this.divisionTeamRank = divisionTeamRank;
		this.gamesPlayed = gamesPlayed;
		this.passAttempts = passAttempts;
		this.passCompletions = passCompletions;
		this.passCompletionsPct = passCompletionsPct;
		this.grossPassYards = grossPassYards;
		this.netPassYards = netPassYards;
		this.passAverageYards = passAverageYards;
		this.passYardsPerAttempt = passYardsPerAttempt;
		this.passTouchdowns = passTouchdowns;
		this.passInterceptions = passInterceptions;
		this.rushAttempts = rushAttempts;
		this.rushYards = rushYards;
		this.rushAverageYards = rushAverageYards;
		this.fumbles = fumbles;
		this.recTouchdowns = recTouchdowns;
		this.sacks = sacks;
		this.tackles = tackles;
		this.safeties = safeties;
		this.interceptions = interceptions;
		this.penalties = penalties;
		this.offenseYards = offenseYards;
		this.totalTouchDowns = totalTouchDowns;
		this.totalTwoPointConversions = totalTwoPointConversions;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamCity() {
		return teamCity;
	}

	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}

	public int getOverallTeamRank() {
		return overallTeamRank;
	}

	public void setOverallTeamRank(int overallTeamRank) {
		this.overallTeamRank = overallTeamRank;
	}

	public String getDivisionTeamRank() {
		return divisionTeamRank;
	}

	public void setDivisionTeamRank(String divisionTeamRank) {
		this.divisionTeamRank = divisionTeamRank;
	}

	public String getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(String gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public String getPassAttempts() {
		return passAttempts;
	}

	public void setPassAttempts(String passAttempts) {
		this.passAttempts = passAttempts;
	}

	public String getPassCompletions() {
		return passCompletions;
	}

	public void setPassCompletions(String passCompletions) {
		this.passCompletions = passCompletions;
	}

	public String getPassCompletionsPct() {
		return passCompletionsPct;
	}

	public void setPassCompletionsPct(String passCompletionsPct) {
		this.passCompletionsPct = passCompletionsPct;
	}

	public String getGrossPassYards() {
		return grossPassYards;
	}

	public void setGrossPassYards(String grossPassYards) {
		this.grossPassYards = grossPassYards;
	}

	public String getNetPassYards() {
		return netPassYards;
	}

	public void setNetPassYards(String netPassYards) {
		this.netPassYards = netPassYards;
	}

	public String getPassAverageYards() {
		return passAverageYards;
	}

	public void setPassAverageYards(String passAverageYards) {
		this.passAverageYards = passAverageYards;
	}

	public String getPassYardsPerAttempt() {
		return passYardsPerAttempt;
	}

	public void setPassYardsPerAttempt(String passYardsPerAttempt) {
		this.passYardsPerAttempt = passYardsPerAttempt;
	}

	public String getPassTouchdowns() {
		return passTouchdowns;
	}

	public void setPassTouchdowns(String passTouchdowns) {
		this.passTouchdowns = passTouchdowns;
	}

	public String getPassInterceptions() {
		return passInterceptions;
	}

	public void setPassInterceptions(String passInterceptions) {
		this.passInterceptions = passInterceptions;
	}

	public String getRushAttempts() {
		return rushAttempts;
	}

	public void setRushAttempts(String rushAttempts) {
		this.rushAttempts = rushAttempts;
	}

	public String getRushYards() {
		return rushYards;
	}

	public void setRushYards(String rushYards) {
		this.rushYards = rushYards;
	}

	public String getRushAverageYards() {
		return rushAverageYards;
	}

	public void setRushAverageYards(String rushAverageYards) {
		this.rushAverageYards = rushAverageYards;
	}

	public String getFumbles() {
		return fumbles;
	}

	public void setFumbles(String fumbles) {
		this.fumbles = fumbles;
	}

	public String getRecTouchdowns() {
		return recTouchdowns;
	}

	public void setRecTouchdowns(String recTouchdowns) {
		this.recTouchdowns = recTouchdowns;
	}

	public String getSacks() {
		return sacks;
	}

	public void setSacks(String sacks) {
		this.sacks = sacks;
	}

	public String getTackles() {
		return tackles;
	}

	public void setTackles(String tackles) {
		this.tackles = tackles;
	}

	public String getSafeties() {
		return safeties;
	}

	public void setSafeties(String safeties) {
		this.safeties = safeties;
	}

	public String getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(String interceptions) {
		this.interceptions = interceptions;
	}

	public String getPenalties() {
		return penalties;
	}

	public void setPenalties(String penalties) {
		this.penalties = penalties;
	}

	public String getOffenseYards() {
		return offenseYards;
	}

	public void setOffenseYards(String offenseYards) {
		this.offenseYards = offenseYards;
	}

	public String getTotalTouchDowns() {
		return totalTouchDowns;
	}

	public void setTotalTouchDowns(String totalTouchDowns) {
		this.totalTouchDowns = totalTouchDowns;
	}

	public String getTotalTwoPointConversions() {
		return totalTwoPointConversions;
	}

	public void setTotalTwoPointConversions(String totalTwoPointConversions) {
		this.totalTwoPointConversions = totalTwoPointConversions;
	}

}
