public class Exchange {
    public Exchange(double dtF, double ftD) {
        DtF = dtF;
        FtD = ftD;
    }

    double dollarToFrancRatio() {
        return DtF;
    }

    double francToDollarRatio() {
        return FtD;
    }

    Dollar francToDollar(Franc franc) {
        return new Dollar(franc.getAmount() / FtD);
    }

    Franc dollarToFranc(Dollar dollar) {
        return new Franc(dollar.getAmount() / DtF);
    }


    private double DtF;
    private double FtD;
}
