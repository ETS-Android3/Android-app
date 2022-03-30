package com.example.rosary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Lum extends Fragment {



    public Lum() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_lum, container, false);

        TextView Lum1 = (TextView) rootView.findViewById(R.id.lmyst1);
        TextView Lum2 = (TextView) rootView.findViewById(R.id.lmyst2);
        TextView Lum3 = (TextView) rootView.findViewById(R.id.lmyst3);
        TextView Lum4 = (TextView) rootView.findViewById(R.id.lmyst4);
        TextView Lum5 = (TextView) rootView.findViewById(R.id.lmyst5);

        Lum1.setText("John answered them, “I baptize with water; but among you stands one whom you do not know, even he who comes after me, the thong of whose sandal I am not worthy to untie.” This took place in Bethany beyond the Jordan, where John was baptizing.\n" +
                "\n" +
                "The Lamb of God\n" +
                "The next day he saw Jesus coming toward him, and said, “Behold, the Lamb of God, who takes away the sin of the world! This is he of whom I said, ‘After me comes a man who ranks before me, for he was before me.’ I myself did not know him; but for this I came baptizing with water, that he might be revealed to Israel.” And John bore witness, “I saw the Spirit descend as a dove from heaven, and it remained on him. I myself did not know him; but he who sent me to baptize with water said to me, ‘He on whom you see the Spirit descend and remain, this is he who baptizes with the Holy Spirit.’ And I have seen and have borne witness that this is the Son of God.”");

        Lum2.setText("On the third day there was a marriage at Cana in Galilee, and the mother of Jesus was there; Jesus also was invited to the marriage, with his disciples. When the wine failed, the mother of Jesus said to him, “They have no wine.” And Jesus said to her, “O woman, what have you to do with me? My hour has not yet come.” His mother said to the servants, “Do whatever he tells you.” Now six stone jars were standing there, for the Jewish rites of purification, each holding twenty or thirty gallons. Jesus said to them, “Fill the jars with water.” And they filled them up to the brim. He said to them, “Now draw some out, and take it to the steward of the feast.” So they took it. When the steward of the feast tasted the water now become wine, and did not know where it came from (though the servants who had drawn the water knew), the steward of the feast called the bridegroom and said to him, “Every man serves the good wine first; and when men have drunk freely, then the poor wine; but you have kept the good wine until now.” This, the first of his signs, Jesus did at Cana in Galilee, and manifested his glory; and his disciples believed in him.\n" +
                "\n" +
                "After this he went down to Caper′na-um, with his mother and his brethren and his disciples; and there they stayed for a few days.");

        Lum3.setText("Now after John was arrested, Jesus came into Galilee, preaching the gospel of God, and saying, “The time is fulfilled, and the kingdom of God is at hand; repent, and believe in the gospel.”");

        Lum4.setText("And after six days Jesus took with him Peter and James and John, and led them up a high mountain apart by themselves; and he was transfigured before them, and his garments became glistening, intensely white, as no fuller on earth could bleach them. And there appeared to them Eli′jah with Moses; and they were talking to Jesus. And Peter said to Jesus, “Master, it is well that we are here; let us make three booths, one for you and one for Moses and one for Eli′jah.” For he did not know what to say, for they were exceedingly afraid. And a cloud overshadowed them, and a voice came out of the cloud, “This is my beloved Son; listen to him.” And suddenly looking around they no longer saw any one with them but Jesus only.\n" +
                "\n" +
                "The Coming of Elijah\n" +
                "And as they were coming down the mountain, he charged them to tell no one what they had seen, until the Son of man should have risen from the dead. So they kept the matter to themselves, questioning what the rising from the dead meant.");

        Lum5.setText("For the bread of God is that which comes down from heaven, and gives life to the world.” They said to him, “Lord, give us this bread always.”\n" +
                "\n" +
                "Jesus said to them, “I am the bread of life; he who comes to me shall not hunger, and he who believes in me shall never thirst. But I said to you that you have seen me and yet do not believe. All that the Father gives me will come to me; and him who comes to me I will not cast out. For I have come down from heaven, not to do my own will, but the will of him who sent me; and this is the will of him who sent me, that I should lose nothing of all that he has given me, but raise it up at the last day. For this is the will of my Father, that every one who sees the Son and believes in him should have eternal life; and I will raise him up at the last day.”\n" +
                "\n" +
                "The Jews then murmured at him, because he said, “I am the bread which came down from heaven.” They said, “Is not this Jesus, the son of Joseph, whose father and mother we know? How does he now say, ‘I have come down from heaven’?” Jesus answered them, “Do not murmur among yourselves. No one can come to me unless the Father who sent me draws him; and I will raise him up at the last day. It is written in the prophets, ‘And they shall all be taught by God.’ Every one who has heard and learned from the Father comes to me. Not that any one has seen the Father except him who is from God; he has seen the Father. Truly, truly, I say to you, he who believes has eternal life. I am the bread of life. Your fathers ate the manna in the wilderness, and they died. This is the bread which comes down from heaven, that a man may eat of it and not die. I am the living bread which came down from heaven; if any one eats of this bread, he will live for ever; and the bread which I shall give for the life of the world is my flesh.”\n" +
                "\n" +
                "The Jews then disputed among themselves, saying, “How can this man give us his flesh to eat?” So Jesus said to them, “Truly, truly, I say to you, unless you eat the flesh of the Son of man and drink his blood, you have no life in you; he who eats my flesh and drinks my blood has eternal life, and I will raise him up at the last day. For my flesh is food indeed, and my blood is drink indeed. He who eats my flesh and drinks my blood abides in me, and I in him. As the living Father sent me, and I live because of the Father, so he who eats me will live because of me. This is the bread which came down from heaven, not such as the fathers ate and died; he who eats this bread will live for ever.” This he said in the synagogue, as he taught at Caper′na-um.");

        return rootView;
    }
}