package id.nano.healthsnap.view;

import id.nano.healthsnap.config.*;
import id.nano.healthsnap.utils.SnapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

@ShellComponent
public class Commands {

    @Autowired
    SnapUtils snap;

    @Autowired
    AtmConfig atmBanking;

    @Autowired
    B2BBankingConfig b2bBanking;

    @Autowired
    InternetBankingConfig internetBanking;

    @Autowired
    MobileBankingConfig mobileBanking;

    @Autowired
    TellerBankingConfig tellerBanking;

    @ShellMethod("Show main menu.")
    public void start() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║             Main Menu             ║");
        System.out.println("║ 1. Atur Bulan                     ║");
        System.out.println("║ 2. Snap Domain ATM                ║");
        System.out.println("║ 3. Snap Domain Mobile Banking     ║");
        System.out.println("║ 4. Snap Domain Internet Banking   ║");
        System.out.println("║ 5. Snap Domain B2B Banking        ║");
        System.out.println("║ 6. Snap Domain Teller Banking     ║");
        System.out.println("║ 7. Keluar                         ║");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.println("Masukan Pilihan Anda:");
    }

    @ShellMethod(value = "Handle Snapping.",key = "2")
    public void snapOption2() throws IOException {
        snap.runSnap(atmBanking);
    }

    @ShellMethod(value = "Handle Snapping.",key = "3")
    public void snapOption3() throws IOException {
        snap.runSnap(mobileBanking);
    }

    @ShellMethod(value = "Handle Snapping.",key = "4")
    public void snapOption4() throws IOException {
        snap.runSnap(internetBanking);
    }

    @ShellMethod(value = "Handle Snapping.",key = "5")
    public void snapOption5() throws IOException {
        snap.runSnap(b2bBanking);
    }

    @ShellMethod(value = "Handle Snapping.",key = "6")
    public void snapOption6() throws IOException {
        snap.runSnap(tellerBanking);
    }

    @ShellMethod(value = "Handle Exiting.",key = "7")
    public void Option7() throws IOException {
        System.exit(-1);
    }

}
