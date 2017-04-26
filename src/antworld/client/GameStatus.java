package antworld.client;

import antworld.common.NestData;
import antworld.common.NestNameEnum;

/**
 * Created by Deb Rezanka on 4/25/2017.
 * This can be used for anything we need
 */
public enum GameStatus
{
  //starting status, need to collect food
  //return to this if below 200 food units in nest
  LOW_FOOD,
  //Our nest or food attacked
  DEFENDING,
  //We are on the offensive
  ATTACKING,
  //Warning status, need to birth ants
  LOW_POPULATION,
  //Warning status, need a new water gathering group
  LOW_WATER,
  EMERGENCY_STATUS;
  //TODO, logic for each game status
  //TODO, ATTACKING, DEFENDING set in ArmyAntClient using the prevStatus here
  public GameStatus getStatus(NestData[] nestData, GameStatus prevStatus, NestNameEnum myNest)
  {
    NestData myData = nestData[myNest.ordinal()];
    int myFood = myData.foodInNest;
    int myWater = myData.waterInNest;
    int score = myData.score;
    int numberOfAnts = ArmyAntClient.getPopulation();

    GameStatus status = prevStatus;

    if(numberOfAnts < 50)
    {
      status = LOW_POPULATION;
    }
    //TODO logic for emergency status
    if(status == LOW_POPULATION && myFood < 200)
    {
      status = EMERGENCY_STATUS;
      return status;
    }
    if(myFood < 200)
    {
      status = LOW_FOOD;
    }
    //Less vital status, May need to send out a new water gathering group
    else if(myWater < 50)
    {
      status = LOW_WATER;
    }
    //if none of the above apply the input prevStatus will be output
    return status;
  }
}


