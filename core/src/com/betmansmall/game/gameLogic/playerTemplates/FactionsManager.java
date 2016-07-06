package com.betmansmall.game.gameLogic.playerTemplates;

import com.badlogic.gdx.utils.Array;

/**
 * Created by betmansmall on 23.02.2016.
 */
public class FactionsManager {
//    private static volatile FactionsManager instance;
//
//    private TemplateForTower currentTemplateTower;
//
//    public static FactionsManager getInstance() {
//        FactionsManager localInstance = instance;
//        if (localInstance == null) {
//            synchronized (FactionsManager.class) {
//                localInstance = instance;
//                if (localInstance == null) {
//                    instance = localInstance = new FactionsManager();
//                }
//            }
//        }
//        return localInstance;
//    }

    private Array<Faction> factions;

    public FactionsManager() {
//        instance = this; //TODO init with singleton
        factions = new Array<Faction>();
    }

    public void addUnitToFaction(TemplateForUnit unit) {
        String newFactionName = unit.getFactionName();
        for(Faction faction: factions) {
            if(faction.getName().equals(newFactionName)) {
                faction.getTemplateForUnits().add(unit);
                unit.setFaction(faction);
                return;
            }
        }
        Faction faction = new Faction(newFactionName);
        faction.getTemplateForUnits().add(unit);
        unit.setFaction(faction);
        factions.add(faction);
    }

    public void addTowerToFaction(TemplateForTower tower) {
//        Gdx.app.log("FactionsManager::addTowerToFaction()", " -- Tower name:" + tower.name);
        String newFactionName = tower.getFactionName();
        for(Faction faction: factions) {
            if(faction.getName().equals(newFactionName)) {
                faction.getTemplateForTowers().add(tower);
                tower.setFaction(faction);
                return;
            }
        }
        Faction faction = new Faction(newFactionName);
        faction.getTemplateForTowers().add(tower);
        tower.setFaction(faction);
        factions.add(faction);
    }

    public TemplateForUnit getRandomTemplateForUnitFromFirstFaction() {
        Faction faction = factions.first();
        if(faction != null) {
            TemplateForUnit templateForUnit = faction.getTemplateForUnits().random();
            if(templateForUnit != null) {
                return templateForUnit;
            }
        }
        return null;
    }

    public TemplateForTower getRandomTemplateForTowerFromFirstFaction() {
        Faction faction = factions.first();
        if(faction != null) {
            TemplateForTower templateForTower = faction.getTemplateForTowers().random();
            if(templateForTower != null) {
                return templateForTower;
            }
        }
        return null;
    }

    public TemplateForUnit getTemplateForUnitFromFirstFactionByIndex(int index) {
        Faction faction = factions.first();
        if(faction != null) {
            TemplateForUnit templateForUnit = faction.getTemplateForUnits().get(index);
            if(templateForUnit != null) {
                return templateForUnit;
            }
        }
        return null;
    }

    public Array<TemplateForTower> getAllFirstTowersFromFirstFaction() {
        return factions.first().getTemplateForTowers();
    }

    public Array<TemplateForTower> getAllTowers(){
        Array<TemplateForTower> allTowers = new Array<TemplateForTower>();
        for(Faction faction : factions) {
            for(TemplateForTower template : faction.getTemplateForTowers()) {
                allTowers.add(template);
            }
        }
        return allTowers;
    }
//    //Mukhin gad
//    public TemplateForTower getCurrentTemplateTower() {
//        if(currentTemplateTower == null) {
//            currentTemplateTower = getAllTowers().get(0);
//        }
//        return currentTemplateTower;
//    }
//
//    public void setCurrentTemplateTower(TemplateForTower currentTemplateTower) {
//        this.currentTemplateTower = currentTemplateTower;
//    }
}
