import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application implements EventHandler<ActionEvent>
{
    private Player player;
    private WeaponsHolder weaponsHolder = WeaponsHolder.getInstance();
    private MonsterHolder monsterHolder = MonsterHolder.getInstance();
    private GameCharacter monster = new GameCharacter("Placeholder", 0, weaponsHolder.getRandomCommonWeapon(), 0, 0);

    private Font labelFont = new Font("Times New Roman", 32);

    private Stage stage;

    private GridPane titleGridpane, mainMenuGridPane, upgradeGridPane, combatGridPane;

    private Scene titleScene, mainMenuScene, upgradeScene, combatScene;

    private Button startButton;
    private Button healthUpgradeButton, damageUpgradeButton;
    private Button adventureButton, shopButton, statsButton, zoneChangeButton;
    private Button attackButton, healButton, magicButton, fleeButton;

    private Label upgradeLabel, playerAttackLabel, enemyAttackLabel;

    public static void main(String[] args)
    {
        Application.launch(args);

    }

    public void start(Stage primaryStage)
    {
        player = new Player("Brave Hero", 200, weaponsHolder.getRandomCommonWeapon());

        stage = primaryStage;
        stage.setResizable(false);
        stage.setTitle("RPG GAME");

        setUpTitleScreen();
        setUpMainMenu();
        setUpCharacterUpgradeScreen();
        setUpCombatScreen();

        stage.setScene(titleScene);

        stage.show();
    }

    private void setUpTitleScreen()
    {
        titleGridpane = new GridPane();
        titleGridpane.setAlignment(Pos.CENTER);
        titleGridpane.setVgap(100);
        titleGridpane.setHgap(10);

        Label titleLabel = new Label("RPG VIDEO GAME");
        titleLabel.setFont(new Font("Times New Roman", 64));
        titleGridpane.add(titleLabel,0,0);
        titleGridpane.setHalignment(titleLabel, HPos.CENTER);

        startButton = new Button("Play Game");
        startButton.setOnAction(this);
        titleGridpane.add(startButton,0,1);
        titleGridpane.setHalignment(startButton, HPos.CENTER);

        titleScene = new Scene(titleGridpane,800,600);
        titleScene.getStylesheets().add("Style.css");
    }

    private void setUpMainMenu()
    {
        mainMenuGridPane = new GridPane();
        mainMenuGridPane.setPadding(new Insets(25,25,25,25));
        mainMenuGridPane.setVgap(250);
        mainMenuGridPane.setAlignment(Pos.TOP_CENTER);

        String mainMenuText = "You are resting at a campfire. What do you wish to do?";
        Label mainMenuLabel = new Label(mainMenuText);
        mainMenuLabel.setWrapText(true);
        mainMenuLabel.setFont(labelFont);

        mainMenuGridPane.add(mainMenuLabel,0,0);

        GridPane mainMenuButtonPane = new GridPane();
        mainMenuButtonPane.setHgap(10);
        mainMenuButtonPane.setVgap(10);
        mainMenuButtonPane.setAlignment(Pos.CENTER);

        adventureButton = new Button("Adventure");
        adventureButton.setOnAction(this);
        shopButton = new Button("Shop");
        statsButton = new Button("View Stats");
        zoneChangeButton = new Button("Change Zone");

        mainMenuButtonPane.add(adventureButton,0,0);
        mainMenuButtonPane.add(shopButton,1,0);
        mainMenuButtonPane.add(statsButton,0,1);
        mainMenuButtonPane.add(zoneChangeButton,1,1);

        mainMenuGridPane.add(mainMenuButtonPane,0,1);
        mainMenuScene = new Scene(mainMenuGridPane, 800, 600);
        mainMenuScene.getStylesheets().add("Style.css");
    }

    private void setUpCharacterUpgradeScreen()
    {
        upgradeLabel = new Label();
        upgradeLabel.setFont(labelFont);
        updateUpgradeSceneText();

        upgradeGridPane = new GridPane();
        upgradeGridPane.setPadding(new Insets(25,25,25,25));
        upgradeGridPane.setVgap(250);
        upgradeGridPane.setAlignment(Pos.TOP_CENTER);

        upgradeGridPane.add(upgradeLabel,0,0);

        GridPane characterUpgradeGridPane = new GridPane();
        characterUpgradeGridPane.setVgap(10);
        characterUpgradeGridPane.setHgap(10);
        characterUpgradeGridPane.setAlignment(Pos.CENTER);

        healthUpgradeButton = new Button("Upgrade Health");
        healthUpgradeButton.setOnAction(this);
        damageUpgradeButton = new Button("Upgrade Damage");
        damageUpgradeButton.setOnAction(this);

        characterUpgradeGridPane.add(healthUpgradeButton,0,0);
        characterUpgradeGridPane.add(damageUpgradeButton,0,1);

        upgradeGridPane.add(characterUpgradeGridPane,0,1);
        upgradeScene = new Scene(upgradeGridPane, 800, 600);
        upgradeScene.getStylesheets().add("Style.css");

    }

    private void setUpCombatScreen ()
    {
        combatGridPane = new GridPane();
        combatGridPane.setAlignment(Pos.TOP_CENTER);

        Label combatLabel = new Label("While adventuring you run into a fearsome foe!");
        playerAttackLabel = new Label();
        enemyAttackLabel = new Label("Placeholder text");

        updateCombatSceneText();

        combatGridPane.add(combatLabel,0,0);
        combatGridPane.add(playerAttackLabel,0,1);
        combatGridPane.add(enemyAttackLabel,0,2);

        attackButton = new Button("Attack");
        attackButton.setOnAction(this);
        healButton = new Button("Heal");
        healButton.setOnAction(this);
        magicButton = new Button("Cast Spell");
        magicButton.setOnAction(this);
        fleeButton = new Button("Flee");
        fleeButton.setOnAction(this);

        GridPane combatButtonPane = new GridPane();
        combatButtonPane.setVgap(10);
        combatButtonPane.setHgap(10);
        combatButtonPane.setAlignment(Pos.CENTER);

        combatButtonPane.add(attackButton,0,0);
        combatButtonPane.add(healButton,0,1);
        combatButtonPane.add(magicButton,1,0);
        combatButtonPane.add(fleeButton,1,1);

        GridPane combatWrapper = new GridPane();
        combatWrapper.setAlignment(Pos.CENTER);
        combatWrapper.setVgap(200);
        combatWrapper.add(combatGridPane,0,0);
        combatWrapper.add(combatButtonPane,0,1);

        combatScene = new Scene(combatWrapper,800,600);
        combatScene.getStylesheets().add("Style.css");
    }

    public void upgradeSceneManager(UpgradeType upgradeType)
    {
        player.upgradeManager(upgradeType);
        updateUpgradeSceneText();
        if (player.getStatPoints() <= 0)
        {
            stage.setScene(mainMenuScene);
        }
    }

    private void updateUpgradeSceneText()
    {
        String upgradeText = String.format("UPGRADE YOUR HERO\nPlayer Name: %s\nHealth: %d\nDamage Multiplier: %f\nPoints Remaining: %d",
                player.getName(), player.getMaxhealth(), player.getDamageMultiplier(), player.getStatPoints());
        upgradeLabel.setText(upgradeText);
    }

    public void updateCombatSceneText()
    {
        String labelText = String.format("PLAYER HP: %d\tAVG-DMG: %f", player.getCurrentHealth(), (player.getDamageMultiplier() * player.getWeapon().getAverageDamage()));
        playerAttackLabel.setText(labelText);
        labelText = String.format("ENEMY HP: %d\tAVG-DMG: %f", monster.getCurrentHealth(), (monster.getDamageMultiplier() * monster.getWeapon().getAverageDamage()));
        enemyAttackLabel.setText(labelText);
    }

    public void handle(ActionEvent event)
    {
        if (event.getSource() == startButton)
        {
            System.out.println("button was pressed");
            stage.setScene(upgradeScene);
        }
        if(stage.getScene() == upgradeScene)
        {
            if (event.getSource() == healthUpgradeButton) {
                upgradeSceneManager(UpgradeType.HEALTH);
            }
            if (event.getSource() == damageUpgradeButton) {
                upgradeSceneManager(UpgradeType.DAMAGE);
            }
        }
        if (event.getSource() == adventureButton)
        {
            stage.setScene(combatScene);
            monster = monsterHolder.getRandomCommonMonster();
            updateCombatSceneText();
        }
        if (stage.getScene() == combatScene)
        {
            if (event.getSource() == attackButton)
            {
                Combat.combatManager(player, monster, AttackType.ATTACK, this);
            }
        }
    }
}
