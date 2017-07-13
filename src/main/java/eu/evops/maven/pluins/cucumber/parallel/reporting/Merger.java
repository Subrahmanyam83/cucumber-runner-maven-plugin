package eu.evops.maven.pluins.cucumber.parallel.reporting;

/**
 * Created by n450777 on 30/03/2016.
 */
public enum Merger {
    Junit(new JunitResultMerger()),
    Json(new JsonResultMerger());

    private ResultMerger merger;
    Merger(ResultMerger merger) {
        this.merger = merger;
    }

    public ResultMerger getMerger() {
        return merger;
    }

    public static ResultMerger get(String merger) throws MergeException {
        for (Merger m : Merger.values()) {
            if(m.name().equalsIgnoreCase(merger)) {
                if(m.name().equals("CustomJSONFormatter")){
                    return Json.getMerger();
                }
                else{
                    return m.getMerger();
                }
            }
        }
        throw new MergeException("Could not find result merger for " + merger.toString());
    }
}
