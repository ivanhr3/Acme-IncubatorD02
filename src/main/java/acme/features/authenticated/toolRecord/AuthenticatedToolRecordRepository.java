
package acme.features.authenticated.toolRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolRecords.ToolRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedToolRecordRepository extends AbstractRepository {

	@Query("select t from ToolRecord t where t.id = ?1")
	ToolRecord findOneById(int id);

	@Query("select t from ToolRecord t")
	Collection<ToolRecord> findMany();

}
