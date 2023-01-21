echo "Uninstallatin process of last windows update"
#Start-Sleep -seconds 5
$uninstall=$false
$currentMachine= hostname
echo "Current HostName is:: $currentMachine" 
$getLastUpdate = Get-HotFix -ComputerName $currentMachine | Select-Object -First 1
if($uninstall -eq $false)
{
    echo "Inside first if"
    if($getLastUpdate -ne '')
    {
        $hotfixId= $getLastUpdate.HotFixId
        echo "The last hotfix id:: $hotfixId"
        #regex check with if then below code
        if($hotfixId -ne '')
        {
            $getOnlyId= $hotfixId -replace 'KB',''
             Invoke-Command -ScriptBlock
            {
                 wusa.exe/uninstall/KB:$getOnlyId/quiet/promptrestart

            }
        }
    }
}
else
{
    #install the last update again
    #set the last hot fix ID as an environment variable
   if($getLastUpdate -ne '')
    {
        $hotfixId= $getLastUpdate.HotFixId
        echo "The last hotfix id:: $hotfixId"
        if($env:LAST_HOTFIXID -ne '')
        {
            $env:LAST_HOTFIXID= $hotfixId
        }
        #regex check with if then below code
        if($hotfixId -ne '')
        {
            #required opeartion to be performed
        }
}