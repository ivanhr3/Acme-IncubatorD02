
package acme.features.anonymous.toolRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolRecords.ToolRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousToolRecordShowService implements AbstractShowService<Anonymous, ToolRecord> {

	@Autowired
	private AnonymousToolRecordRepository repository;


	@Override
	public boolean authorise(final Request<ToolRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<ToolRecord> request, final ToolRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "sector.name", "inventor", "description", "web", "email", "openSource", "stars");
	}

	@Override
	public ToolRecord findOne(final Request<ToolRecord> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		ToolRecord result = this.repository.findOneById(id);

		return result;
	}

}
