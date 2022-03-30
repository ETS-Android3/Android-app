package com.example.rosary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Glory extends Fragment {


    public Glory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_glory, container, false);

        TextView Glo1 = (TextView) rootView.findViewById(R.id.gmyst1);
        TextView Glo2 = (TextView) rootView.findViewById(R.id.gmyst2);
        TextView Glo3 = (TextView) rootView.findViewById(R.id.gmyst3);
        TextView Glo4 = (TextView) rootView.findViewById(R.id.gmyst4);
        TextView Glo5 = (TextView) rootView.findViewById(R.id.gmyst5);

        Glo1.setText("The Resurrection of Jesus\n" +
                "Now on the first day of the week Mary Mag′dalene came to the tomb early, while it was still dark, and saw that the stone had been taken away from the tomb. So she ran, and went to Simon Peter and the other disciple, the one whom Jesus loved, and said to them, “They have taken the Lord out of the tomb, and we do not know where they have laid him.” Peter then came out with the other disciple, and they went toward the tomb. They both ran, but the other disciple outran Peter and reached the tomb first; and stooping to look in, he saw the linen cloths lying there, but he did not go in. Then Simon Peter came, following him, and went into the tomb; he saw the linen cloths lying, and the napkin, which had been on his head, not lying with the linen cloths but rolled up in a place by itself. Then the other disciple, who reached the tomb first, also went in, and he saw and believed; for as yet they did not know the scripture, that he must rise from the dead. Then the disciples went back to their homes.\n" +
                "\n" +
                "Jesus Appears to Mary Magdalene\n" +
                "But Mary stood weeping outside the tomb, and as she wept she stooped to look into the tomb; and she saw two angels in white, sitting where the body of Jesus had lain, one at the head and one at the feet. They said to her, “Woman, why are you weeping?” She said to them, “Because they have taken away my Lord, and I do not know where they have laid him.” Saying this, she turned round and saw Jesus standing, but she did not know that it was Jesus. Jesus said to her, “Woman, why are you weeping? Whom do you seek?” Supposing him to be the gardener, she said to him, “Sir, if you have carried him away, tell me where you have laid him, and I will take him away.” Jesus said to her, “Mary.” She turned and said to him in Hebrew, “Rab-bo′ni!” (which means Teacher). Jesus said to her, “Do not hold me, for I have not yet ascended to the Father; but go to my brethren and say to them, I am ascending to my Father and your Father, to my God and your God.” Mary Mag′dalene went and said to the disciples, “I have seen the Lord”; and she told them that he had said these things to her.\n" +
                "\n" +
                "Jesus Appears to the Disciples\n" +
                "On the evening of that day, the first day of the week, the doors being shut where the disciples were, for fear of the Jews, Jesus came and stood among them and said to them, “Peace be with you.” When he had said this, he showed them his hands and his side. Then the disciples were glad when they saw the Lord. Jesus said to them again, “Peace be with you. As the Father has sent me, even so I send you.” And when he had said this, he breathed on them, and said to them, “Receive the Holy Spirit. If you forgive the sins of any, they are forgiven; if you retain the sins of any, they are retained.”\n" +
                "\n" +
                "Jesus and Thomas\n" +
                "Now Thomas, one of the twelve, called the Twin, was not with them when Jesus came. So the other disciples told him, “We have seen the Lord.” But he said to them, “Unless I see in his hands the print of the nails, and place my finger in the mark of the nails, and place my hand in his side, I will not believe.”\n" +
                "\n" +
                "Eight days later, his disciples were again in the house, and Thomas was with them. The doors were shut, but Jesus came and stood among them, and said, “Peace be with you.” Then he said to Thomas, “Put your finger here, and see my hands; and put out your hand, and place it in my side; do not be faithless, but believing.” Thomas answered him, “My Lord and my God!” Jesus said to him, “Have you believed because you have seen me? Blessed are those who have not seen and yet believe.”");

        Glo2.setText("So when they had come together, they asked him, “Lord, will you at this time restore the kingdom to Israel?” He said to them, “It is not for you to know times or seasons which the Father has fixed by his own authority. But you shall receive power when the Holy Spirit has come upon you; and you shall be my witnesses in Jerusalem and in all Judea and Samar′ia and to the end of the earth.” And when he had said this, as they were looking on, he was lifted up, and a cloud took him out of their sight. And while they were gazing into heaven as he went, behold, two men stood by them in white robes, and said, “Men of Galilee, why do you stand looking into heaven? This Jesus, who was taken up from you into heaven, will come in the same way as you saw him go into heaven.”");

        Glo3.setText("The Holy Spirit Comes at Pentecost\n" +
                "When the day of Pentecost came, they were all together in one place. Suddenly a sound like the blowing of a violent wind came from heaven and filled the whole house where they were sitting. They saw what seemed to be tongues of fire that separated and came to rest on each of them. All of them were filled with the Holy Spirit and began to speak in other tongues as the Spirit enabled them.\n" +
                "\n" +
                "Now there were staying in Jerusalem God-fearing Jews from every nation under heaven. When they heard this sound, a crowd came together in bewilderment, because each one heard their own language being spoken. Utterly amazed, they asked: “Aren’t all these who are speaking Galileans? Then how is it that each of us hears them in our native language? Parthians, Medes and Elamites; residents of Mesopotamia, Judea and Cappadocia, Pontus and Asia, Phrygia and Pamphylia, Egypt and the parts of Libya near Cyrene; visitors from Rome (both Jews and converts to Judaism); Cretans and Arabs—we hear them declaring the wonders of God in our own tongues!” Amazed and perplexed, they asked one another, “What does this mean?”\n" +
                "\n" +
                "Some, however, made fun of them and said, “They have had too much wine.”\n" +
                "\n" +
                "Peter Addresses the Crowd\n" +
                "Then Peter stood up with the Eleven, raised his voice and addressed the crowd: “Fellow Jews and all of you who live in Jerusalem, let me explain this to you; listen carefully to what I say. These people are not drunk, as you suppose. It’s only nine in the morning! No, this is what was spoken by the prophet Joel:\n" +
                "\n" +
                " “‘In the last days, God says,\n" +
                "    I will pour out my Spirit on all people.\n" +
                " Your sons and daughters will prophesy,\n" +
                "    your young men will see visions,\n" +
                "    your old men will dream dreams.\n" +
                " Even on my servants, both men and women,\n" +
                "    I will pour out my Spirit in those days,\n" +
                "    and they will prophesy.\n" +
                " I will show wonders in the heavens above\n" +
                "    and signs on the earth below,\n" +
                "    blood and fire and billows of smoke.\n" +
                " The sun will be turned to darkness\n" +
                "    and the moon to blood\n" +
                "    before the coming of the great and glorious day of the Lord.\n" +
                " And everyone who calls\n" +
                "    on the name of the Lord will be saved.’\n" +
                "\n" +
                " “Fellow Israelites, listen to this: Jesus of Nazareth was a man accredited by God to you by miracles, wonders and signs, which God did among you through him, as you yourselves know. This man was handed over to you by God’s deliberate plan and foreknowledge; and you, with the help of wicked men, put him to death by nailing him to the cross. But God raised him from the dead, freeing him from the agony of death, because it was impossible for death to keep its hold on him. David said about him:\n" +
                "\n" +
                "“‘I saw the Lord always before me.\n" +
                "    Because he is at my right hand,\n" +
                "    I will not be shaken.\n" +
                " Therefore my heart is glad and my tongue rejoices;\n" +
                "    my body also will rest in hope,\n" +
                " because you will not abandon me to the realm of the dead,\n" +
                "    you will not let your holy one see decay.\n" +
                " You have made known to me the paths of life;\n" +
                "    you will fill me with joy in your presence.’\n" +
                "\n" +
                " “Fellow Israelites, I can tell you confidently that the patriarch David died and was buried, and his tomb is here to this day. But he was a prophet and knew that God had promised him on oath that he would place one of his descendants on his throne. Seeing what was to come, he spoke of the resurrection of the Messiah, that he was not abandoned to the realm of the dead, nor did his body see decay. God has raised this Jesus to life, and we are all witnesses of it. Exalted to the right hand of God, he has received from the Father the promised Holy Spirit and has poured out what you now see and hear. For David did not ascend to heaven, and yet he said,\n" +
                "\n" +
                "“‘The Lord said to my Lord:\n" +
                "    “Sit at my right hand\n" +
                " until I make your enemies\n" +
                "    a footstool for your feet.”’\n" +
                "\n" +
                "“Therefore let all Israel be assured of this: God has made this Jesus, whom you crucified, both Lord and Messiah.”\n" +
                "\n" +
                "When the people heard this, they were cut to the heart and said to Peter and the other apostles, “Brothers, what shall we do?”\n" +
                "\n" +
                "Peter replied, “Repent and be baptized, every one of you, in the name of Jesus Christ for the forgiveness of your sins. And you will receive the gift of the Holy Spirit. The promise is for you and your children and for all who are far off—for all whom the Lord our God will call.”\n" +
                "\n" +
                "With many other words he warned them; and he pleaded with them, “Save yourselves from this corrupt generation.” Those who accepted his message were baptized, and about three thousand were added to their number that day.");

        Glo4.setText("Then God’s temple in heaven was opened, and the ark of his covenant was seen within his temple; and there were flashes of lightning, loud noises, peals of thunder, an earthquake, and heavy hail.");

        Glo5.setText("And a great portent appeared in heaven, a woman clothed with the sun, with the moon under her feet, and on her head a crown of twelve stars;");

        return rootView;
    }
}