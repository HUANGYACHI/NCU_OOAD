package UML_Buttons;

import UML_Manager.EventManager;

public class GeneralizationLineButton extends MyButton{
	public GeneralizationLineButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.GENERALIZATION_LINE);
		return;
	}
}
