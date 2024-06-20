import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Realm {
    private static BufferedReader br;
    private static Characters player = null;
    private static Battle battle = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Введите имя персонажа");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Player(string, 100, 0, 20, 0, 20);
            System.out.println(String.format("Добро пожаловать, странник, нашему миру угрожает опасность, скелеты и гоблины заполонили этот мир! Желаю удачи, %s!", player.getName()));
            printNavigation();
        }
        switch (string) {
            case "1": {
                System.out.println("Торговца пока нет на месте");
                command(br.readLine());
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static void commitFight() {
        battle.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s, вы победили! Теперь у вас %d опыта и %d золота, осталось %d единиц здоровья.", player.getName(), player.getExperience(), player.getGold(), player.getHealth()));
                System.out.println("Хотите продолжить поход? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {
                System.out.println(String.format("%s, к сожалению, монстер одалел вас, вы потеряли весь свой опыт и золото, хотите начать путешествие заново?", player.getName()));
            }
        });
    }

    private static Characters createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin("Гоблин", 50, 20, 10, 100, 10);
        else return new Skeleton("Скелет", 25, 10, 20, 100, 20);

    }
}