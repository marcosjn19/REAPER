
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class Auto_DriveTiempo extends CommandBase {
  //ATRIBUTOS (TIEMPO, SUBSISTEMA, ¿TERMINADO?, CRONOMETRO)
  private int tiempo;
  DriveSubsystem driveTrain;
  private boolean finish = false;
  Timer crono;
//-------------------------------------------------------------------------
  //CONSTRUCTOR QUE RECIBE COMO PARAMETRO EL SUBSISTEMA Y EL TIEMPO
  public Auto_DriveTiempo(DriveSubsystem driveSubsystem, int tiempo) {
    driveTrain = driveSubsystem;
    addRequirements(driveTrain);
    crono = new Timer();
    this.tiempo = tiempo;
  }

//-------------------------------------------------------------------------  
  @Override
  public void initialize() {
    crono.reset();
    crono.start();
    //AQUI VA EL TIEMPO
    while( crono.get() < tiempo ){
      driveTrain.driveFrente(1.5);
    }
    finish = true;

  }

//-------------------------------------------------------------------------
  @Override
  public void execute() {}

//-------------------------------------------------------------------------
  @Override
  public void end(boolean interrupted) {
    driveTrain.stopDrive();
  }

//-------------------------------------------------------------------------
  @Override
  public boolean isFinished() {
    return finish;
  }
}
