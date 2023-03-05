
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class TP_DriveCommand extends CommandBase {
//-------------------------------------------------------------------------  
private final DriveSubsystem driveTrain;
//-------------------------------------------------------------------------
  //CONSTRUCTOR
  public TP_DriveCommand(DriveSubsystem driveSubsystem) {
    driveTrain = driveSubsystem;
    addRequirements(driveSubsystem);
  }

//-------------------------------------------------------------------------
  @Override
  public void initialize() {}

//-------------------------------------------------------------------------
  @Override
  public void execute() {
    driveTrain.driveWithController(RobotContainer.driverController);
  }

//-------------------------------------------------------------------------
  @Override
  public void end(boolean interrupted) {}

//-------------------------------------------------------------------------
  @Override
  public boolean isFinished() {
    return false;
  }
}
