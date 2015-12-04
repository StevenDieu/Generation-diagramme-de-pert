package view;

import java.util.List;

public class ViewPert extends FunctionView {

	private static final long serialVersionUID = 1L;

	public ViewPert(List<List<Object>> listInfosGraphs, int tamponsX, int heightFrame) {

		this.addCircle(listInfosGraphs, tamponsX, heightFrame);

	}

}
