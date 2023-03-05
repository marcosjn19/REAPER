
package frc.robot;

import frc.robot.commands.Auto_DriveTiempo;
import frc.robot.commands.TP_DriveCommand;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;



public class RobotContainer {
//-------------------------------------------------------------------------
  SendableChooser<Command> m_AutoChooser = new SendableChooser<>();
  
  private final DriveSubsystem driveTrain;
  private final TP_DriveCommand driveControl;
  public static XboxController driverController;
  private final Auto_DriveTiempo auto_DriveTiempo;

//-------------------------------------------------------------------------
  public RobotContainer() {

    driveTrain = new DriveSubsystem();
    driveControl = new TP_DriveCommand(driveTrain);
    driveControl.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveControl);

    //SE LE PONE EL TIEMPO DENTRO DEL CONSTRUCTOR
    auto_DriveTiempo = new Auto_DriveTiempo(driveTrain, 3);
    auto_DriveTiempo.addRequirements(driveTrain);

    m_AutoChooser.addOption("Drive Reversa", auto_DriveTiempo);
    driverController = new XboxController(Constants.OperatorConstants.kDriverControllerPort);

    configureBindings();
  }
//-------------------------------------------------------------------------

  public Command getAutoCommand(){
    return m_AutoChooser.getSelected();
  }

//-------------------------------------------------------------------------
  private void configureBindings() {

  }
//-------------------------------------------------------------------------
  public Command getAutonomousCommand() {
    return getAutoCommand();
  }
}
