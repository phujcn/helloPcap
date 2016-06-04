/**
 * Created by phujcn on 19/05/2016.
 */
import org.pcap4j.*;
import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

public class hellopcap {
    public static void main(String[] args){
        PcapHandle h = null;
        Packet packet = null;
        boolean runFlag = true;
        String filename ="C:\\Users\\phujcn\\Desktop\\WorkSpace\\pcaps\\example.pcap";
        int nPackets = 0;
        int iCount = 0;

        System.out.println("Hello pcap!");
        try {
            h = Pcaps.openOffline(filename);
        }
        catch (PcapNativeException ex){
            ex.printStackTrace();
        }
        try {
            while (true){
                 packet = h.getNextPacket();
                if (packet == null) {
                    break;
                }
                else{
                    iCount+=1;
                }
            }
            System.out.printf("Number of packets in pcap = %d",iCount);
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        }
        catch (NotOpenException ex){
            ex.printStackTrace();
            }
        }
}
