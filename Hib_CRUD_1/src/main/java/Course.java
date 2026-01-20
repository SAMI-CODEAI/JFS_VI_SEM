public class Course {
	private int cid;
	private String cname;
	private String ccontent;
	private int duration;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int cid, String cname, String ccontent, int duration) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ccontent = ccontent;
		this.duration = duration;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccontent == null) ? 0 : ccontent.hashCode());
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + duration;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (ccontent == null) {
			if (other.ccontent != null)
				return false;
		} else if (!ccontent.equals(other.ccontent))
			return false;
		if (cid != other.cid)
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (duration != other.duration)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return cid+" "+cname+" "+ccontent+" "+duration;
//		return "Course [cid=" + cid + ", cname=" + cname + ", ccontent=" + ccontent + ", duration=" + duration
//				+ ", getCid()=" + getCid() + ", getCname()=" + getCname() + ", getCcontent()=" + getCcontent()
//				+ ", getDuration()=" + getDuration() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
//				+ ", toString()=" + super.toString() + "]";
	}
	
//	generate constructors, setter, getter methods, equals(), hashCode() and toString() methods
  
	
	
	
} 
	