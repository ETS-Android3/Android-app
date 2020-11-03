package com.example.rosary;

public class Prayer {

    String ApostleCreed [] = {"I believe in God, the Father Almighty\nCreator of heaven and earth",
            "I believe in Jesus Christ,\nHis only son our Lord", "Who was conceived by the Holy Spirit" +
            "\nAnd born of the Virgin Mary", "He suffered under Pontius Pilate\nWas crucified " +
            "died and was buried", "He descended into hell\nThe third day he rose again from the dead",
    "He ascended to heaven\nand is seated at the right hand of God the Father almighty.",
    "From there he will come to judge the living and the dead.",
    "I believe in the Holy Spirit,\nthe holy catholic* church,", " the communion of saints,\n" +
            "the forgiveness of sins,", "the resurrection of the body,\nand the life everlasting. Amen"};

    String HailMary []= {"Hail Mary, full of grace\nThe Lord is with thee",
            "Blessed are thou among woman\nAnd blessed be the fruit thy womb Jesus",
            "Holy Mary, Mother of God\nPray for us sinners",
            "Now and at the our of our death\nAmen"};

    String GloryBe [] = {"Glory be to the Father,\nThe Son and the Holy Spirit",
            "As it was in the Beginning\nIs now and forever", "World without end\nAmen"};

    String OurFather [] = {"Our Father, who art in heaven\nHallowed by thy name",
            "Thy kingdom come, thy will be done\nOn earth as it is in heaven",
            "Give us this day, our daily bread\nAnd forgive us our trespasses",
            "As we forgive those who trespass against us\nAnd lead us not into temptation",
            "But deliver us from evil\nAmen"};

    String HolyQueen [] = {"Hail, holy Queen, Mother of mercy, hail, our life, our sweetness and our hope.",
    "To thee do we cry, poor banished children of Eve:", "to thee do we send up our sighs, mourning and weeping in this vale of tears.",
            "Turn then, most gracious Advocate, thine eyes of mercy toward us,", "and after this our exile, show unto us the blessed fruit of thy womb, Jesus,",
            "O merciful, O loving, O sweet Virgin Mary! Amen."};

    String Empty [] = {"Pray"};

    public String [] getEmpty() {return Empty.clone(); }

    public String [] getApostle(){
        return ApostleCreed.clone();
    }

    public String [] getMary(){
        return HailMary.clone();
    }

    public String [] getGlory(){
        return GloryBe.clone();
    }

    public String [] getOurFather(){
        return OurFather.clone();
    }

    public String [] getOurHolyQueen() {return HolyQueen.clone();}
}
