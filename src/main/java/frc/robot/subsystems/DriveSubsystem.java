/*------------------------------------------------------------------------------------------
:*                         		      CBTIS 159
:*                               FRC CP-BOTS 4355
:*                   	TEMPORADA: 2023   RETO: CHARGED-UP
:*
:*                          Subsistema del Drive
:*        
:*  Archivo     : DriveSubsystem.java
:*  FechaCreacion       : 27/02/2023
:*  Tipo  : Subsistema
:*  Descripción :  Subsistema para controlar el Drive del robot "REAPER"
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*========================================================================================== 
:* 
:*------------------------------------------------------------------------------------------*/


package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  //DECLARACION DE CONTROLADORES
  private final VictorSP right = new VictorSP(Constants.puertoDriveDer);
  private final VictorSP left = new VictorSP(Constants.puertoDriveIzq);
//-------------------------------------------------------------------------
  //CONSTRUCTOR
  public DriveSubsystem() {}

  public void differentialDrive ( double velIzq, double velDer ){
    left.set(velIzq);
    right.set(velDer);
  }
//-------------------------------------------------------------------------

  public void driveWithController (XboxController controller) {

  left.setInverted(true);

  if(controller.getRawAxis(3)>0){
    right.set(-controller.getRawAxis(3)*.60);
    left.set(-controller.getRawAxis(3)*.70);
  }else{

  if(controller.getRawAxis(2)>0){
    right.set(controller.getRawAxis(2)*.60);
    left.set(controller.getRawAxis(2)*.70);
  }else{



    right.set(controller.getRawAxis(5)*.90);
    left.set(controller.getRawAxis(1));
  }}
  }

//-------------------------------------------------------------------------

  public void driveFrente ( double vel ){
    left.setInverted(true);
    right.set(vel);
    left.set(vel);
    
  }

//-------------------------------------------------------------------------
  public void stopDrive (){

    right.set(0);
    left.set(0);

  }

//-------------------------------------------------------------------------
  @Override
  public void periodic() {
    
  }
}
