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

/*
TODO: fix WeaponsHolder and Combat so they properly employ the singleton design pattern
 */
public class Game extends Application implements EventHandler<ActionEvent>
{
    private Player player;
    private GameCharacter monster;
    private WeaponsHolder weaponsHolder = WeaponsHolder.getInstance();
    private MonsterHolder monsterHolder = MonsterHolder.getInstance();
    private Shop shop = Shop.getInstance();

    private Font labelFont = new Font("Times New Roman", 32);

    private Stage stage;

    private GridPane titleGridpane, mainMenuGridPane, upgradeGridPane, combatGridPane, postCombatGridPane;

    private Scene titleScene, mainMenuScene, upgradeScene, combatScene, postCombatScene, statsScene, shopScene;

    private Button startButton;
    private Button healthUpgradeButton, damageUpgradeButton, magicUpgradeButton, manaUpgradeButton;
    private Button adventureButton, shopButton, statsButton, zoneChangeButton;
    private Button attackButton, healButton, magicButton, fleeButton;
    private Button continueButton;
    private Button statsContinueButton;
    private Button shopButton1, shopButton2, shopButton3, shopButton4, leaveShopButton;

    private Label upgradeLabel, playerAttackLabel, enemyAttackLabel, postCombatLabel, statsLabel, shopLabel;

    public static void main(String[] args)
    {
        Application.launch(args);

    }

    //Initializing all necessary components for the game
    public void start(Stage primaryStage)
    {
        player = new Player("Brave Hero", 10, weaponsHolder.getRandomCommonWeapon());
        monster = new GameCharacter("Placeholder", 0, weaponsHolder.getRandomCommonWeapon(), 0, 0, 0);

        stage = primaryStage;
        stage.setResizable(true);
        stage.setTitle("RPG GAME");

        setUpTitleScreen();
        setUpMainMenu();
        setUpCharacterUpgradeScreen();
        setUpCombatScreen();
        setUpPostCombatScreen();
        setUpStatsScreen();
        setUpShopScreen();

        stage.setScene(titleScene);

        stage.show();
    }

    //Methods to set up each screen
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
        mainMenuGridPane.setVgap(100);
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
        shopButton.setOnAction(this);
        statsButton = new Button("View Stats");
        statsButton.setOnAction(this);
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
        upgradeGridPane.setVgap(100);
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
        manaUpgradeButton = new Button("Upgrade Mana");
        manaUpgradeButton.setOnAction(this);
        magicUpgradeButton = new Button("Upgrade Magic");
        magicUpgradeButton.setOnAction(this);

        characterUpgradeGridPane.add(healthUpgradeButton,0,0);
        characterUpgradeGridPane.add(damageUpgradeButton,0,1);
        characterUpgradeGridPane.add(magicUpgradeButton,0,2);
        characterUpgradeGridPane.add(manaUpgradeButton,0,3);

        upgradeGridPane.add(characterUpgradeGridPane,0,1);
        upgradeScene = new Scene(upgradeGridPane, 800, 600);
        upgradeScene.getStylesheets().add("Style.css");

    }

    private void setUpCombatScreen()
    {
        combatGridPane = new GridPane();
        combatGridPane.setAlignment(Pos.TOP_CENTER);

        Label combatLabel = new Label("While adventuring you run into a fearsome foe!");
        playerAttackLabel = new Label();
        enemyAttackLabel = new Label("Placeholder text");

        updateCombatSceneText();

        //combatGridPane.add(combatLabel,1,0);
        combatGridPane.add(playerAttackLabel,0,1);
        combatGridPane.add(enemyAttackLabel,1,1);
        System.out.println(combatGridPane.hgapProperty());

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
        combatWrapper.setVgap(100);
        combatWrapper.add(combatGridPane,0,0);
        combatWrapper.add(combatButtonPane,0,1);

        combatScene = new Scene(combatWrapper,800,600);
        combatScene.getStylesheets().add("Style.css");
    }

    //Screen to provide a summary of all combat encounters
    private void setUpPostCombatScreen()
    {
        postCombatGridPane = new GridPane();
        postCombatGridPane.setAlignment(Pos.CENTER);

        postCombatLabel = new Label("Placeholder Text");

        continueButton = new Button("Continue");
        continueButton.setOnAction(this);

        postCombatGridPane.add(postCombatLabel,0,0);
        postCombatGridPane.add(continueButton,0,1);

        postCombatScene = new Scene(postCombatGridPane, 800, 600);
        postCombatScene.getStylesheets().add("Style.css");


    }

    private void setUpStatsScreen()
    {
        GridPane statsGridPane = new GridPane();
        statsGridPane.setAlignment(Pos.CENTER);

        statsLabel = new Label();

        statsContinueButton = new Button("Continue");
        statsContinueButton.setOnAction(this);

        statsGridPane.add(statsLabel, 0, 0);
        statsGridPane.add(statsContinueButton,0,1);

        statsScene = new Scene(statsGridPane, 800, 600);
        statsScene.getStylesheets().add("Style.css");
    }

    private void setUpShopScreen()
    {
        GridPane shopPane = new GridPane();
        shopPane.setAlignment(Pos.CENTER);

        shopLabel = new Label("PlaceHolder");

        shopButton1 = new Button("Item 1");
        shopButton2 = new Button("Item 2");
        shopButton3 = new Button("Item 3");
        shopButton4 = new Button("Item 4");
        leaveShopButton = new Button ("Leave Shop");
        leaveShopButton.setOnAction(this);

        GridPane buttonPane = new GridPane();
        buttonPane.setAlignment(Pos.CENTER);

        buttonPane.add(shopButton1, 0 ,0);
        buttonPane.add(shopButton2, 1,0);
        buttonPane.add(shopButton3, 0,1);
        buttonPane.add(shopButton4, 1 ,1);

        GridPane leavePane = new GridPane();
        leavePane.setAlignment(Pos.CENTER);
        leavePane.add(leaveShopButton,0,0);

        shopPane.add(shopLabel, 0,0);
        shopPane.add(buttonPane,0,1);
        shopPane.add(leavePane,0,2);

        shopScene = new Scene(shopPane, 800, 600);
        shopScene.getStylesheets().add("Style.css");


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

    //Methods to update text after a change has been made
    private void updateUpgradeSceneText()
    {
        String upgradeText = String.format("UPGRADE YOUR HERO\nPlayer Name: %s\nHealth: %d\nDamage Multiplier: %.1f\nMagic Damage: %d\nMana: %d\nPoints Remaining: %d",
                player.getName(), player.getMaxhealth(), player.getDamageMultiplier(), player.getMagicDamage(), player.getMaxMana(), player.getStatPoints());
        upgradeLabel.setText(upgradeText);
    }

    public void updateCombatSceneText()
    {
        String labelText = String.format("%s\nHP: %d\nAVG-DMG: %.1f\nMANA: %d\nMAGIC-DMG: %d", player.getName(), player.getCurrentHealth(),
                (player.getDamageMultiplier() * player.getWeapon().getAverageDamage()), player.getCurrentMana(), player.getMagicDamage());
        playerAttackLabel.setText(labelText);
        labelText = String.format("%s\nHP: %d\nAVG-DMG: %.1f", monster.getName(), monster.getCurrentHealth(), (monster.getDamageMultiplier() * monster.getWeapon().getAverageDamage()));
        enemyAttackLabel.setText(labelText);
    }

    public void updatePostCombatSceneText(String text)
    {
        postCombatLabel.setText(text);
    }

    private void updateStatsScreenText()
    {
        String labelText = String.format("%s\nLevel: %d\nMax Health: %d\nDamage Multiplier: %.2f\nWeapon: %s\nAvg Weapon Damage: %d\nGold: %d\nXP: %d/%d",
                player.getName(), player.getLevel(), player.getMaxhealth(), player.getDamageMultiplier(),
                player.getWeapon().getName(), player.getWeapon().getAverageDamage(), player.getGold(), player.getXp(), player.getXpToNextLevel());
        statsLabel.setText(labelText);
    }

    //Event handler for every button in the game
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
            if (event.getSource() == magicUpgradeButton)
            {
                upgradeSceneManager(UpgradeType.MAGIC);
            }
            if (event.getSource() == manaUpgradeButton)
            {
                upgradeSceneManager(UpgradeType.MANA);
            }
        }
        if (stage.getScene() == mainMenuScene)
        {
            if (event.getSource() == adventureButton)
            {
                monster = monsterHolder.getRandomCommonMonster();
                updateCombatSceneText();
                stage.setScene(combatScene);
            }
            if (event.getSource() == statsButton)
            {
                updateStatsScreenText();
                stage.setScene(statsScene);
            }
            if (event.getSource() == shopButton)
            {
                shop.updateShopText(shopLabel);
                stage.setScene(shopScene);
            }

        }
        if (stage.getScene() == combatScene)
        {
            if (event.getSource() == attackButton)
            {
                Combat.combatManager(player, monster, AttackType.ATTACK, this, stage, postCombatScene);
            }
            if (event.getSource() == healButton)
            {
                Combat.combatManager(player, monster, AttackType.HEAL, this, stage, postCombatScene);
            }
            if (event.getSource() == fleeButton)
            {
                Combat.combatManager(player, monster, AttackType.FLEE, this, stage, postCombatScene);
            }
            if (event.getSource() == magicButton)
            {
                Combat.combatManager(player, monster, AttackType.MAGIC, this, stage, postCombatScene);
            }
        }
        if (event.getSource() == continueButton || event.getSource() == statsContinueButton)
        {
            if (player.getStatPoints() >= 1)
            {
                stage.setScene(upgradeScene);
            }
            else
            {
                stage.setScene(mainMenuScene);
            }
        }

        if (stage.getScene() == shopScene)
        {
            if (event.getSource() == leaveShopButton)
            {
                stage.setScene(mainMenuScene);
            }
        }
    }
}
