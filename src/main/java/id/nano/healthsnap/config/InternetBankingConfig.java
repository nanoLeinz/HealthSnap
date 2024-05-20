package id.nano.healthsnap.config;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InternetBankingConfig extends Config {
    public List<String> CORE_SERVICES = Arrays.asList("Throughput", "HeapUsedCurrent", "OpenSocketsCurrentCount");
    public List<String> HOST_SERVICES = Arrays.asList("ProcessorUsagePercent", "PhysicalMemoryUsedPercent");
    public List<String> DATASOURCE_SERVICES = Arrays.asList(
            "CIDBDataSource/NumAvailable", "CIDBDataSource/ActiveConnectionsCurrentCount",
            "DSPLKTAGridLink/NumAvailable", "DSPLKTAGridLink/ActiveConnectionsCurrentCount",
            "ESBDataSourceGridLink/NumAvailable", "ESBDataSourceGridLink/ActiveConnectionsCurrentCount",
            "ESBSeqGridlink/NumAvailable", "ESBSeqGridlink/ActiveConnectionsCurrentCount",
            "wlsbjmsrpDataSource/NumAvailable", "wlsbjmsrpDataSource/ActiveConnectionsCurrentCount",
            "WNADataSource_NonXAGridlink/NumAvailable", "WNADataSource_NonXAGridlink/ActiveConnectionsCurrentCount"
    );
    public String BASE_URI = "http://11.11.111.111:11111/domainhealth/charts/";
    public String MISC = "-23-59-59&duration=1440&scope=ALL&direction=current";
    public String USERNAME = "weblogic";
    public String PASSWORD = "111w111";
}
