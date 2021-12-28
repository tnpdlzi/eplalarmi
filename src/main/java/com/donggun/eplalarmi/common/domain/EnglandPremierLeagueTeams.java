package com.donggun.eplalarmi.common.domain;

import lombok.Getter;

@Getter
public enum EnglandPremierLeagueTeams {
    MANCITY("Manchester City F.C.", "MCI"), LIVERPOOL("Liverpool F.C.", "LIV"),
    CHELSEA("Chelsea F.C.", "CHE"), ARSENAL("Arsenal F.C.", "ARS"),
    TOTTENHAM("Tottenham Hotspur F.C.", "TOT"), WESTHAM("West Ham United F.C.", "WHU"),
    MANUTD("Manchester United F.C.", "MUN"), WOLVES("Wolverhampton Wanderers F.C.", "WOL"),
    BRIGHTON("Brighton & Hove Albion F.C.", "BHA"), LEICESTER("Leicester City F.C.", "LEI"),
    ASTONVILLA("Aston Villa F.C.", "AVL"), CRYSTALPALACE("Crystal Palace F.C.", "CRY"),
    BRENTFORD("Brentford F.C.", "BRE"), SOUTHAMPTON("Southampton F.C.", "SOU"),
    EVERTON("Everton F.C.", "EVE"), LEEDS("Leeds United F.C.", "LEE"),
    WATFORD("Watford F.C.", "WAT"), BURNLEY("Burnley F.C.", "BRN"),
    NEWCASTLE("Newcastle United F.C.", "NEW"), NORWICH("Norwich City F.C.", "NOR");

    private final String teamName;
    private final String teamAbbr;

    EnglandPremierLeagueTeams(String teamName, String teamAbbr) {
        this.teamName = teamName;
        this.teamAbbr = teamAbbr;
    }
}
