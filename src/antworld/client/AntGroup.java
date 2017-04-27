package antworld.client;


import antworld.common.AntType;
import antworld.common.PacketToClient;
import antworld.common.PacketToServer;
import antworld.common.AntAction;
import antworld.common.AntAction.AntState;
import antworld.common.AntData;
import antworld.common.Constants;
import antworld.common.Direction;
import antworld.common.NestNameEnum;
import antworld.common.TeamNameEnum;
import antworld.common.AntAction.AntActionType;

import java.util.ArrayList;


/**
 * Created by hIM on 4/24/2017.
 */
public abstract  class AntGroup
{

  int count;
  ArrayList<AntData> antlist = new ArrayList<>();
  Direction dir;

  //generate the number of ants needed for this group


  public ArrayList<AntData> getAntList (){
    return antlist;
  }

  void addAnt (AntData ant) {
    antlist.add(ant);
  }

  void remove () {
    antlist.clear();
  }

  //the arrangement for each ant can be define with it spawn position
  abstract void spawn(int x, int y);
  abstract void chooseAction();

  }





