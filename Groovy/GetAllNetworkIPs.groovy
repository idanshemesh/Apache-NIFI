//////////////////////////////////////////////////
// This script loop on all network cards and    //
// put them in folwfile attribute:              //
// host.ip.N     - the ip                       //
// host.ip.count - Numer of IPs                 //
//                                              //
// Git: https://github.com/idanshemesh          //
//                                              //
//////////////////////////////////////////////////

import java.io.*
import java.net.*
import java.util.*

def flowFile = session.get()
if(!flowFile) return

def counter = 0
//Get all my network cards IPs
def interfaces = NetworkInterface.getNetworkInterfaces()
while (interfaces.hasMoreElements()) {
    def addresses = interfaces.nextElement().getInetAddresses()
    while (addresses.hasMoreElements()) {
        def ip = addresses.nextElement().getHostAddress()
        if (ip != '127.0.0.1') {
         flowFile = session.putAttribute(flowFile, 'host.ip.' + counter, ip)
         counter++
        }
    }
}


flowFile = session.putAttribute(flowFile, 'host.ip.count', counter.toString())

session.transfer(flowFile, REL_SUCCESS)
