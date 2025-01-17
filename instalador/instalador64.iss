; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "Otimizador de PDF - JT"
#define MyAppVersion "101"
#define MyAppPublisher "TRT 14"
#define MyAppURL "http://www.trt14.jus.br/conversor-pdf"
#define MyAppExeName "conversor.exe"


[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{D65829C9-DA0B-43A2-BD5D-4E4F5956615F}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\{#MyAppName}
DisableDirPage=yes
DefaultGroupName={#MyAppName}
AllowNoIcons=yes
OutputDir=/
OutputBaseFilename=setup_64_rev_{#MyAppVersion}
SetupIconFile=..\src\main\resources\images\ConversorPDF.ico
Compression=lzma2/ultra64
SolidCompression=yes

[Languages]
Name: brazilianportuguese; MessagesFile: compiler:Languages\BrazilianPortuguese.isl

[Tasks]
Name: desktopicon; Description: {cm:CreateDesktopIcon}; GroupDescription: {cm:AdditionalIcons}; 
Name: quicklaunchicon; Description: {cm:CreateQuickLaunchIcon}; GroupDescription: {cm:AdditionalIcons}; Flags: unchecked; OnlyBelowVersion: 0,6.1

[Files]
Source: conversor.exe; DestDir: {app}; Flags: ignoreversion
Source: ..\src\main\resources\images\ConversorPDF.ico; DestDir: {app}; Flags: ignoreversion
Source: ..\gsdll64.dll; DestDir: {app}; Flags: ignoreversion
Source: jre_64\*; DestDir: {app}; Flags: ignoreversion recursesubdirs createallsubdirs
Source: print\*; DestDir: {app}; Flags: ignoreversion recursesubdirs createallsubdirs
Source: ..\tesseract-3.0.4\*; DestDir: {app}; Flags: ignoreversion recursesubdirs createallsubdirs; Excludes: "\tessdata"
Source: atalho.vbs; DestDir: {app}; Flags: ignoreversion
Source: removeatalho.vbs; DestDir: {app}; Flags: ignoreversion uninsneveruninstall
Source: ..\vcredist_x64.exe; DestDir: {app}; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: {group}\{cm:ProgramOnTheWeb,{#MyAppName}}; Filename: {#MyAppURL}
Name: {group}\{cm:UninstallProgram,{#MyAppName}}; Filename: {uninstallexe}
Name: {commondesktop}\{#MyAppName}; Filename: {app}\{#MyAppExeName}; Tasks: desktopicon
Name: {userappdata}\Microsoft\Internet Explorer\Quick Launch\{#MyAppName}; Filename: {app}\{#MyAppExeName}; Tasks: quicklaunchicon
Name: {sendto}\Otimizador de PDF - JT - Juntar; Filename: {app}\conversor.exe; IconIndex: 0
Name: {sendto}\Otimizador de PDF - JT - Otimizar; Filename: {app}\conversor.exe; IconIndex: 0

Name: {group}\{#MyAppName}; Filename: {app}\{#MyAppExeName}
Name: {group}\Otimizador de PDF - JT - Modo Depura��o; Filename: {app}\jre\bin\java.exe; IconFilename: {app}\ConversorPDF.ico; Parameters: "-jar ""{app}\{#MyAppExeName}"""; WorkingDir:  {app}
Name: {app}\Otimizador de PDF - JT - Modo Depura��o; Filename: {app}\jre\bin\java.exe; IconFilename: {app}\ConversorPDF.ico; Parameters: "-jar ""{app}\{#MyAppExeName}"""; \
WorkingDir:  {app}


[Run]

Filename: {app}\vcredist_x64.exe; Parameters:"/quiet /install"; Check: VCRedistNeedsInstall; StatusMsg: Instalando VC++ 2015 64 Redistributables... 
Filename: {app}\{#MyAppExeName}; Description: {cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}; Flags: postinstall skipifsilent nowait   
Filename: {app}\print\install.bat; Flags: shellexec runhidden; StatusMsg: Instalando impressora...
Filename: {app}\atalho.vbs; Flags: shellexec runhidden; StatusMsg: Criando atalhos...

[UninstallRun]
Filename: {app}\removeatalho.vbs; Flags: shellexec runhidden; StatusMsg: Removendo atalhos...
Filename: {app}\print\uninstall.bat; Flags: shellexec runhidden nowait

[Code]

#IFDEF UNICODE
  #DEFINE AW "W"
#ELSE
  #DEFINE AW "A"
#ENDIF
type
  INSTALLSTATE = Longint;
const
  INSTALLSTATE_INVALIDARG = -2;  // An invalid parameter was passed to the function.
  INSTALLSTATE_UNKNOWN = -1;     // The product is neither advertised or installed.
  INSTALLSTATE_ADVERTISED = 1;   // The product is advertised but not installed.
  INSTALLSTATE_ABSENT = 2;       // The product is installed for a different user.
  INSTALLSTATE_DEFAULT = 5;      // The product is installed for the current user.

VC_2015_REDIST_X86_ADD = '{BE960C1C-7BAD-3DE6-8B1A-2616FE532845}';
VC_2015_REDIST_X64_ADD = '{BC958BD2-5DAC-3862-BB1A-C1BE0790438D}';


function MsiQueryProductState(szProduct: string): INSTALLSTATE; 
  external 'MsiQueryProductState{#AW}@msi.dll stdcall';

function VCVersionInstalled(const ProductID: string): Boolean;
begin
  Result := MsiQueryProductState(ProductID) = INSTALLSTATE_DEFAULT;
end;
function VCRedistNeedsInstall: Boolean;
begin
  Result := not (VCVersionInstalled(VC_2015_REDIST_X64_ADD));
end;



