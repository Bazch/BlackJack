public enum Ranks {
    TWEE(2),
    DRIE(3),
    VIER(4),
    VIJF(5),
    ZES(6),
    ZEVEN(7),
    ACHT(8),
    NEGEN(9),
    TIEN(10),
    BOER(10),
    VROUW(10),
    HEER(10),
    AAS(11);

    private  int rankValue;

        private Ranks (int value){
        this.rankValue = value;
    }

    public int getRankValue() {
        return rankValue;
    }
    public void setRankValue(int rankValue) {
        this.rankValue = rankValue;
    }
}