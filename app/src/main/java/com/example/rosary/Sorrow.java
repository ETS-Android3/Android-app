package com.example.rosary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sorrow#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sorrow extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sorrow() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sorrow.
     */
    // TODO: Rename and change types and number of parameters
    public static Sorrow newInstance(String param1, String param2) {
        Sorrow fragment = new Sorrow();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_sorrow, container, false);

        TextView Sor1 = (TextView) rootView.findViewById(R.id.smyst1);
        TextView Sor2 = (TextView) rootView.findViewById(R.id.smyst2);
        TextView Sor3 = (TextView) rootView.findViewById(R.id.smyst3);
        TextView Sor4 = (TextView) rootView.findViewById(R.id.smyst4);
        TextView Sor5 = (TextView) rootView.findViewById(R.id.smyst5);

        Sor1.setText("Jesus Prays in Gethsemane\n" +
                "Then Jesus went with them to a place called Gethsem′ane, and he said to his disciples, “Sit here, while I go yonder and pray.” And taking with him Peter and the two sons of Zeb′edee, he began to be sorrowful and troubled. Then he said to them, “My soul is very sorrowful, even to death; remain here, and watch with me.” And going a little farther he fell on his face and prayed, “My Father, if it be possible, let this cup pass from me; nevertheless, not as I will, but as thou wilt.” And he came to the disciples and found them sleeping; and he said to Peter, “So, could you not watch with me one hour? Watch and pray that you may not enter into temptation; the spirit indeed is willing, but the flesh is weak.” Again, for the second time, he went away and prayed, “My Father, if this cannot pass unless I drink it, thy will be done.” 43 And again he came and found them sleeping, for their eyes were heavy. So, leaving them again, he went away and prayed for the third time, saying the same words. Then he came to the disciples and said to them, “Are you still sleeping and taking your rest? Behold, the hour is at hand, and the Son of man is betrayed into the hands of sinners. Rise, let us be going; see, my betrayer is at hand.”");

        Sor2.setText("I will therefore chastise him and release him.”\n" +
                "\n" +
                "But they all cried out together, “Away with this man, and release to us Barab′bas”— a man who had been thrown into prison for an insurrection started in the city, and for murder. Pilate addressed them once more, desiring to release Jesus; but they shouted out, “Crucify, crucify him!” A third time he said to them, “Why, what evil has he done? I have found in him no crime deserving death; I will therefore chastise him and release him.”");

        Sor3.setText("And the soldiers led him away inside the palace (that is, the praetorium); and they called together the whole battalion. And they clothed him in a purple cloak, and plaiting a crown of thorns they put it on him. And they began to salute him, “Hail, King of the Jews!” And they struck his head with a reed, and spat upon him, and they knelt down in homage to him. And when they had mocked him, they stripped him of the purple cloak, and put his own clothes on him. And they led him out to crucify him.");

        Sor4.setText("And after that they had mocked him, they took the robe off from him, and put his own raiment on him, and led him away to crucify him.\n" +
                "\n" +
                "And as they came out, they found a man of Cyrene, Simon by name: him they compelled to bear his cross.");

        Sor5.setText("And when they came to a place called Gol′gotha (which means the place of a skull), they offered him wine to drink, mingled with gall; but when he tasted it, he would not drink it. 35 And when they had crucified him, they divided his garments among them by casting lots; 36 then they sat down and kept watch over him there. And over his head they put the charge against him, which read, “This is Jesus the King of the Jews.” Then two robbers were crucified with him, one on the right and one on the left. And those who passed by derided him, wagging their heads and saying, “You who would destroy the temple and build it in three days, save yourself! If you are the Son of God, come down from the cross.” So also the chief priests, with the scribes and elders, mocked him, saying, “He saved others; he cannot save himself. He is the King of Israel; let him come down now from the cross, and we will believe in him. He trusts in God; let God deliver him now, if he desires him; for he said, ‘I am the Son of God.’” And the robbers who were crucified with him also reviled him in the same way.\n" +
                "\n" +
                "The Death of Jesus\n" +
                "Now from the sixth hour there was darkness over all the land until the ninth hour. And about the ninth hour Jesus cried with a loud voice, “Eli, Eli, la′ma sabach-tha′ni?” that is, “My God, my God, why hast thou forsaken me?” And some of the bystanders hearing it said, “This man is calling Eli′jah.” And one of them at once ran and took a sponge, filled it with vinegar, and put it on a reed, and gave it to him to drink. But the others said, “Wait, let us see whether Eli′jah will come to save him.” And Jesus cried again with a loud voice and yielded up his spirit.\n" +
                "\n" +
                "And behold, the curtain of the temple was torn in two, from top to bottom; and the earth shook, and the rocks were split; the tombs also were opened, and many bodies of the saints who had fallen asleep were raised, and coming out of the tombs after his resurrection they went into the holy city and appeared to many. 54 When the centurion and those who were with him, keeping watch over Jesus, saw the earthquake and what took place, they were filled with awe, and said, “Truly this was the Son of God!”");

        return rootView;
    }
}