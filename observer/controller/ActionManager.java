package controller;

import controller.action.*;

public class ActionManager {
    private NewAciton newAciton;

    private NewNodeAction newNodeAction;

    private InfoAction infoAction;
    private EditAction editAction;
    private DeleteAction deleteAction;
    private PrezentacijaViewAction prezentacijaViewAction;
    private ExitSlajdShowAction exitSlajdShowAction;
    private NewSlotAction newSlotAction;
    private SelectSlotAction selectSlotAction;
    private MoveSlotAction moveSlotAction;
    private DeleteSlotAction deleteSlotAction;
    private SlotColorAction slotColorAction;
    private EditSlotAction editSlotAction;

    private UndoAction undoAction;
    private RedoAction redoAction;

    private BoldAction boldAction;
    private UnderlineAction underlineAction;
    private ItalicAction italicAction;

    private SharePrezentacijaAction sharePrezentacijaAction;

    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;

    private OpenPrezentacijaAction openPrezentacijaAction;
    private SavePrezentacijaAction savePrezentacijaAction;

    private SaveWorkspaceAction saveWorkspaceAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        newAciton = new NewAciton();

        newNodeAction = new NewNodeAction();

        infoAction = new InfoAction();
        editAction = new EditAction();
        deleteAction = new DeleteAction();
        prezentacijaViewAction = new PrezentacijaViewAction();
        exitSlajdShowAction = new ExitSlajdShowAction();
        newSlotAction = new NewSlotAction();
        selectSlotAction = new SelectSlotAction();
        moveSlotAction = new MoveSlotAction();
        deleteSlotAction = new DeleteSlotAction();
        slotColorAction = new SlotColorAction();
        editSlotAction = new EditSlotAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();

        boldAction = new BoldAction();
        underlineAction = new UnderlineAction();
        italicAction = new ItalicAction();

        sharePrezentacijaAction = new SharePrezentacijaAction();

        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();

        savePrezentacijaAction = new SavePrezentacijaAction();
        openPrezentacijaAction = new OpenPrezentacijaAction();

        saveWorkspaceAction = new SaveWorkspaceAction();

    }

    public NewNodeAction getNewNodeAction() {
        return newNodeAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public NewAciton getNewAciton() {
        return newAciton;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public PrezentacijaViewAction getPrezentacijaViewAction() {
        return prezentacijaViewAction;
    }

    public ExitSlajdShowAction getExitSlajdShowAction() {
        return exitSlajdShowAction;
    }

    public NewSlotAction getNewSlotAction() {
        return newSlotAction;
    }

    public SelectSlotAction getSelectSlotAction() {
        return selectSlotAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public SlotColorAction getSlotColorAction() {
        return slotColorAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public EditSlotAction getEditSlotAction() {
        return editSlotAction;
    }

    public BoldAction getBoldAction() {
        return boldAction;
    }

    public SharePrezentacijaAction getSharePrezentacijaAction() {
        return sharePrezentacijaAction;
    }

    public UnderlineAction getUnderlineAction() {
        return underlineAction;
    }

    public ItalicAction getItalicAction() {
        return italicAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public OpenPrezentacijaAction getOpenPrezentacijaAction() {
        return openPrezentacijaAction;
    }

    public SavePrezentacijaAction getSavePrezentacijaAction() {
        return savePrezentacijaAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }
}
