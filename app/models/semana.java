package models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import play.db.ebean.Model;

import java.util.*;

@Entity
public class semana extends Model {
	@Id
	@Min(1)
	@Max(6)
	public int id;

	@OneToMany(cascade=CascadeType.ALL)
	public List<metas> Smetas;
	
	public semana(){}
	
	public semana(int id){
		this.id = id;
		this.Smetas = new ArrayList<metas>();
	}
	public static Finder<Integer, semana> find = new Finder<Integer, semana>(Integer.class, semana.class);

	public void add(metas meta){
		Smetas.add(meta);
	}
	
	public static void save(semana Semana) {
		Semana.save();
	}
	
	public static semana getById(int id) {
		return find.byId(id);
	}
	
	public static List<semana> all() {
		return find.all();
	}
	
	public List<metas> getMetas() {
		Collections.sort(Smetas, new Comparator<metas>() {
			
			public int compare(metas arg0, metas arg1) {
				return arg0.prioridade - arg1.prioridade;
			}			
		});
		
		return Smetas;
	}
}
