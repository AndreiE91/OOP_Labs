package lab12;


public class CounterController {
		private boolean stop;
		private long count;
		private CounterView view;
		
		public CounterController()
		{
			view = new CounterView();
			view.addActionListener(e -> {
				Thread t = new Thread() {
					public void run() {
						stop = false;
						while (count<10000)
						{
						if (stop) break;
							view.setCounterLabel(count++);
							try {
								Thread.sleep(10);
								}
							catch (Exception exc)
							{
								System.out.println("Eroare");
							}
						}
					}
				};
				t.start();
			});
			view.addActionListener2(e -> {
				stop = true;
			});
		}
}
