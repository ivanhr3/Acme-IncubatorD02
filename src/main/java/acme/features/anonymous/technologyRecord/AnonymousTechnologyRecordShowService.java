
package acme.features.anonymous.technologyRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.technologyRecords.TechnologyRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousTechnologyRecordShowService implements AbstractShowService<Anonymous, TechnologyRecord> {

	@Autowired
	private AnonymousTechnologyRecordRepository repository;


	@Override
	public boolean authorise(final Request<TechnologyRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "sector.name", "inventor", "description", "web", "email", "openSource", "stars");
	}

	@Override
	public TechnologyRecord findOne(final Request<TechnologyRecord> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		TechnologyRecord result = this.repository.findOneById(id);

		return result;
	}

}
