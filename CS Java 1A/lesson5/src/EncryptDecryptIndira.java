import java.util.Scanner;

/*
Encrypts and Decrypts text using a ceasar cipher when given the correct shift key.
The program will check if the shift key is valid and if not it will return "Bad Key".
 */

public class EncryptDecryptIndira {
   public static void main(String[] args) {

      // initialize variables
      int shiftKey = 0;
      char c;
      int charValue = 0;
      char transformedChar;

      // initialize Scanner
      Scanner input = new Scanner(System.in);
      input.useDelimiter("\\n");

      // checks if shiftKey is out of valid range
      if (input.hasNextInt()) {
         shiftKey = input.nextInt();
         if (shiftKey > 25 || shiftKey < -25) {
            System.out.println("Bad Key");
            System.exit(0);
         }
      }
      //if there is no integer shiftKey
      else {
         System.out.println("Bad Key");
         System.exit(0);
      }

      // checks if there are more lines
      while (input.hasNextLine()) {
         String line = input.nextLine().toLowerCase();

         // loops through and encrypts each character in the line
         for(int i = 0; i < line.length(); i++) {
            c = line.charAt(i);
            charValue = (int)c;

            // prints the char if it is not a letter
            if (charValue < 97 || charValue > 122) {
               System.out.print(c);
               continue;
            }
            // encrypts when the char is a letter
            else {
               charValue -= 'a';
               charValue = (charValue + shiftKey) % 26;

               if (charValue < 0) charValue += 26;
               charValue += 'a';
               transformedChar = (char) charValue;
               System.out.print(transformedChar);
            }
         }
         System.out.println("");
      }
   }
}

/*
Indiras-MacBook-Pro:src indiram$ java EncryptDecryptIndira <  GettysburgAddress.txt

ajpm nxjmz viy nzqzi tzvmn vbj jpm avoczmn wmjpbco ajmoc ji ocdn xjiodizio,
v izr ivodji, xjixzdqzy di gdwzmot, viy yzydxvozy oj ocz kmjkjndodji ocvo vgg
hzi vmz xmzvozy zlpvg.

ijr rz vmz zibvbzy di v bmzvo xdqdg rvm, oznodib rczoczm ocvo ivodji, jm vit
ivodji nj xjixzdqzy viy nj yzydxvozy, xvi gjib ziypmz. rz vmz hzo ji v bmzvo
wvoogz-adzgy ja ocvo rvm. rz cvqz xjhz oj yzydxvoz v kjmodji ja ocvo adzgy, vn
v adivg mznodib kgvxz ajm ocjnz rcj czmz bvqz oczdm gdqzn ocvo ocvo ivodji
hdbco gdqz. do dn vgojbzoczm adoodib viy kmjkzm ocvo rz ncjpgy yj ocdn.

wpo, di v gvmbzm nzinz, rz xvi ijo yzydxvoz - rz xvi ijo xjinzxmvoz - rz xvi ijo
cvggjr - ocdn bmjpiy. ocz wmvqz hzi, gdqdib viy yzvy, rcj nompbbgzy czmz, cvqz
xjinzxmvozy do, avm vwjqz jpm kjjm kjrzm oj vyy jm yzomvxo. ocz rjmgy rdgg gdoogz
ijoz, ijm gjib mzhzhwzm rcvo rz nvt czmz, wpo do xvi izqzm ajmbzo rcvo oczt ydy
czmz. do dn ajm pn ocz gdqdib, mvoczm, oj wz yzydxvozy czmz oj ocz piadidnczy
rjmf rcdxc oczt rcj ajpbco czmz cvqz ocpn avm nj ijwgt vyqvixzy. do dn mvoczm
ajm pn oj wz czmz yzydxvozy oj ocz bmzvo ovnf mzhvdidib wzajmz pn - ocvo amjh ocznz
cjijmzy yzvy rz ovfz dixmzvnzy yzqjodji oj ocvo xvpnz ajm rcdxc oczt bvqz ocz gvno
apgg hzvnpmz ja yzqjodji - ocvo rz czmz cdbcgt mznjgqz ocvo ocznz yzvy ncvgg ijo cvqz
ydzy di qvdi - ocvo ocdn ivodji, piyzm bjy, ncvgg cvqz v izr wdmoc ja amzzyjh - viy
ocvo bjqzmihzio ja ocz kzjkgz, wt ocz kzjkgz, ajm ocz kzjkgz, ncvgg ijo kzmdnc
amjh ocz zvmoc.
Indiras-MacBook-Pro:src indiram$ java EncryptDecryptIndira <  IHaveADream.txt

q aig bw gwc bwlig, ug nzqmvla, aw mdmv bpwcop em nikm bpm lqnnqkctbqma wn bwlig ivl bwuwzzwe, q abqtt pidm i lzmiu. qb qa i lzmiu lmmxtg zwwbml qv bpm iumzqkiv lzmiu.
q pidm i lzmiu bpib wvm lig bpqa vibqwv eqtt zqam cx ivl tqdm wcb bpm bzcm umivqvo wn qba kzmml: "em pwtl bpmam bzcbpa bw jm amtn-mdqlmvb: bpib itt umv izm kzmibml mycit."
q pidm i lzmiu bpib wvm lig wv bpm zml pqtta wn omwzoqi bpm awva wn nwzumz atidma ivl bpm awva wn nwzumz atidm wevmza eqtt jm ijtm bw aqb lwev bwombpmz ib bpm bijtm wn jzwbpmzpwwl.
q pidm i lzmiu bpib wvm lig mdmv bpm abibm wn uqaaqaaqxxq, i abibm aemtbmzqvo eqbp bpm pmib wn qvrcabqkm, aemtbmzqvo eqbp bpm pmib wn wxxzmaaqwv, eqtt jm bzivanwzuml qvbw iv wiaqa wn nzmmlwu ivl rcabqkm.
q pidm i lzmiu bpib ug nwcz tqbbtm kpqtlzmv eqtt wvm lig tqdm qv i vibqwv epmzm bpmg eqtt vwb jm rcloml jg bpm kwtwz wn bpmqz asqv jcb jg bpm kwvbmvb wn bpmqz kpizikbmz.
q pidm i lzmiu bwlig.
q pidm i lzmiu bpib wvm lig, lwev qv itijiui, eqbp qba dqkqwca zikqaba, eqbp qba owdmzvwz pidqvo pqa tqxa lzqxxqvo eqbp bpm ewzla wn qvbmzxwaqbqwv ivl vcttqnqkibqwv; wvm lig zqopb bpmzm qv itijiui, tqbbtm jtiks jwga ivl jtiks oqzta eqtt jm ijtm bw rwqv pivla eqbp tqbbtm epqbm jwga ivl epqbm oqzta ia aqabmza ivl jzwbpmza.
q pidm i lzmiu bwlig.
Indiras-MacBook-Pro:src indiram$ java EncryptDecryptIndira <  gout.txt

four score and seven years ago our fathers brought forth on this continent,
a new nation, conceived in liberty, and dedicated to the proposition that all
men are created equal.

now we are engaged in a great civil war, testing whether that nation, or any
nation so conceived and so dedicated, can long endure. we are met on a great
battle-field of that war. we have come to dedicate a portion of that field, as
a final resting place for those who here gave their lives that that nation
might live. it is altogether fitting and proper that we should do this.

but, in a larger sense, we can not dedicate - we can not consecrate - we can not
hallow - this ground. the brave men, living and dead, who struggled here, have
consecrated it, far above our poor power to add or detract. the world will little
note, nor long remember what we say here, but it can never forget what they did
here. it is for us the living, rather, to be dedicated here to the unfinished
work which they who fought here have thus far so nobly advanced. it is rather
for us to be here dedicated to the great task remaining before us - that from these
honored dead we take increased devotion to that cause for which they gave the last
full measure of devotion - that we here highly resolve that these dead shall not have
died in vain - that this nation, under god, shall have a new birth of freedom - and
that government of the people, by the people, for the people, shall not perish
from the earth.
Indiras-MacBook-Pro:src indiram$ java EncryptDecryptIndira <  iout.txt

i say to you today, my friends, so even though we face the difficulties of today and tomorrow, i still have a dream. it is a dream deeply rooted in the american dream.
i have a dream that one day this nation will rise up and live out the true meaning of its creed: "we hold these truths to be self-evident: that all men are created equal."
i have a dream that one day on the red hills of georgia the sons of former slaves and the sons of former slave owners will be able to sit down together at the table of brotherhood.
i have a dream that one day even the state of mississippi, a state sweltering with the heat of injustice, sweltering with the heat of oppression, will be transformed into an oasis of freedom and justice.
i have a dream that my four little children will one day live in a nation where they will not be judged by the color of their skin but by the content of their character.
i have a dream today.
i have a dream that one day, down in alabama, with its vicious racists, with its governor having his lips dripping with the words of interposition and nullification; one day right there in alabama, little black boys and black girls will be able to join hands with little white boys and white girls as sisters and brothers.
i have a dream today.
Indiras-MacBook-Pro:src indiram$ java EncryptDecryptIndira <  badkey1.txt
Bad Key
Indiras-MacBook-Pro:src indiram$ java EncryptDecryptIndira <  badkey2.txt
Bad Key
Indiras-MacBook-Pro:src indiram$

 */