import java.util.List;

public class People {
    public final static Person JanKowalski =
            new Person(30, 1200);
    public final static Person MateuszNowak =
            new Person(56, 3000);
    public final static Person AnnaBuda =
            new Person( 22, 4500);
    public final static Person ConchitaWurst =
            new Person(36, 12000);
    public final static Person MariaKowalewicz=
            new Person(46, 1500);
    public final static Person AnetaUrban=
            new Person( 21, 4200);
    public final static Person ZdzislawSzydlowski=
            new Person(38, 6800);
    public final static Person JanAnrusowski=
            new Person( 49, 1250);
    public final static Person JanuszKowalski=
            new Person(18, 1000);
    public final static Person DanutaKowalska=
            new Person(27, 1200);

    public static List<Person> Data = List.of(
            JanKowalski,
            MateuszNowak,
            JanuszKowalski,
            AnetaUrban,
            AnnaBuda,
            ConchitaWurst,
            MariaKowalewicz,
            ZdzislawSzydlowski,
            JanAnrusowski,
            DanutaKowalska
    );
}
