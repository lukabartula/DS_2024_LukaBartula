package week3.labTask;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        long searchedIP = convertToIPNumber(ipAddress);

        int low = 0;
        int high = ipAddresses.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (searchedIP < ipAddresses[mid].getStartIp()) {
                high = mid - 1;
            } else if (searchedIP > ipAddresses[mid].getEndIp()) {
                low = mid + 1;
            } else {
                return ipAddresses[mid];
            }
        }
        return null;

    }

    public static long convertToIPNumber(String IPAddress) {
        String[] split = IPAddress.split("\\.");
        return (16777216L * Integer.parseInt(split[0]))
                + (65536L * Integer.parseInt(split[1]))
                + (256L * Integer.parseInt(split[2]))
                + Integer.parseInt(split[3]);
    }
}




