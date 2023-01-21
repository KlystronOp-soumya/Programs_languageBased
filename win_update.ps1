echo "Hello World"
$uninstall=$false
$hotfixId='KB'
$currentMachine= hostname
$getLastUpdate = Get-HotFix -ComputerName $currentMachine | Select-Object -First 1

Get-HotFix $hotfixId

if($uninstall -eq $true)
{
    Invoke-Command -ScriptBlock
    {
        wusa.exe/uninstall/KB:($hotfixId -replace 'KB','')/quiet/norestart

    }
}
else
{
    echo "can not be unistalled last update"
}


