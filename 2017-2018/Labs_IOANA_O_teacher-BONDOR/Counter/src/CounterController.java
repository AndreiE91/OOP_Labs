
public class CounterController {

	private boolean stop;
	private long count;
	private CounterView view = new CounterView();

	public CounterController() {
		
		view.start.addActionListener(e -> {
			stop = false;
			while (count > 10000) {
				if (stop) {
					break;}
					count++;
					String string = Long.toString(count);
				view.setCounterLabel(string);
				}
		});
		
		view.stop.addActionListener( e-> {
			stop = true;
		});

		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		view.setVisible(true);
}

}
