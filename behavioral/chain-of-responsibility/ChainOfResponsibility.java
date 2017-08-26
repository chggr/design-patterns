// The chain of responsibility is a behavioral software design pattern that
// consists of a chain of receiver objects forming a processing pipeline.
// Senders launch and leave their requests at the entrance of the processing
// pipeline and each request is passed on from one receiver to the next until
// it reaches a receiver capable of processing it. In many cases the number of
// receivers in the chain is not known beforehand and might vary in runtime.
//
// This pattern allows efficient processing of requests without coupling the
// sender of a request to its receiver or hard-wiring request-to-handler
// mappings. Each receiver only knows its successor and does not have a view of
// the full chain. In some cases, receivers may send requests in more than one
// directions and thus form a tree of responsibility. In other cases, the chain
// can be recursive, thus allowing each receiver to handle part of the request
// and pass on the remaining to receivers higher up in the chain until the full
// request is processed.
//
// Advantages:
// - Decouples the sender of a request and the receiver.
// - Promotes loose coupling, makes it easy to add receivers to the chain.
//
// Disadvantages:
// - No handling guarantee: Request will not be handled if no capable handler
//   exists in the chain.
// - Chain length might cause performance issues.
//
// Examples: Logger, Servlet Filter, Spring Security Filter chain
//
// In the example below we have a series of Request handlers that are linked
// together in a chain: Secretary => Analyst => Associate => Director =>
// Managing Director. Senders leave their requests at the beginning of the
// chain (i.e. with the Secretary) and each request passes along from one
// handler to the next until it reaches a handler that can take a decision
// either to approve or reject it. In more detail:
// 
// - Secretary: Will reject all requests without a description and approve
//              all requests valued lower than their threshold.
//
// - Analyst / Associate / Director: Will approve all requests valued lower
//                                   than their threeshold.
//
// - Managing Director: Will approve all requests valued lower than their
//                      threshold and reject all other requests.

public class ChainOfResponsibility {

    private static boolean testNullRequestDescription(Secretary secretary) {
        final Request request = new Request(1, 100, null);
        final Response response = secretary.handle(request);
        return Response.Type.REJECTED.equals(response.getType()) &&
               "TinTin".equals(response.getActionedBy());
    }

    private static boolean testEmptyRequestDescription(Secretary secretary) {
        final Request request = new Request(2, 100, "");
        final Response response = secretary.handle(request);
        return Response.Type.REJECTED.equals(response.getType()) &&
               "TinTin".equals(response.getActionedBy());
    }

    private static boolean testRequestApprovedSecretary(Secretary secretary) {
        final Request request = new Request(3, 4, "Office pens");
        final Response response = secretary.handle(request);
        return Response.Type.APPROVED.equals(response.getType()) &&
               "TinTin".equals(response.getActionedBy());
    }

    private static boolean testRequestApprovedAnalyst(Secretary secretary) {
        final Request request = new Request(4, 12, "Printer ink");
        final Response response = secretary.handle(request);
        return Response.Type.APPROVED.equals(response.getType()) &&
               "Madame Bovary".equals(response.getActionedBy());
    }

    private static boolean testRequestApprovedAssociate(Secretary secretary) {
        final Request request = new Request(5, 154, "PC Monitor");
        final Response response = secretary.handle(request);
        return Response.Type.APPROVED.equals(response.getType()) &&
               "Hannibal Lecter".equals(response.getActionedBy());
    }

    private static boolean testRequestApprovedDirector(Secretary secretary) {
        final Request request = new Request(6, 1200, "Conference fees");
        final Response response = secretary.handle(request);
        return Response.Type.APPROVED.equals(response.getType()) &&
               "Hercule Poirot".equals(response.getActionedBy());
    }

    private static boolean testRequestApprovedMD(Secretary secretary) {
        final Request request = new Request(7, 11700, "Computer hardware");
        final Response response = secretary.handle(request);
        return Response.Type.APPROVED.equals(response.getType()) &&
               "Anna Karenina".equals(response.getActionedBy());
    }

    private static boolean testRequestRejectedMD(Secretary secretary) {
        final Request request = new Request(8, 120000, "Office renovation");
        final Response response = secretary.handle(request);
        return Response.Type.REJECTED.equals(response.getType()) &&
               "Anna Karenina".equals(response.getActionedBy());
    }

    public static void main(String[] args) {
        ManagingDirector md = new ManagingDirector("Anna Karenina", 100000, null);
        Director director = new Director("Hercule Poirot", 10000, md);
        Associate associate = new Associate("Hannibal Lecter", 1000, director);
        Analyst analyst = new Analyst("Madame Bovary", 100, associate);
        Secretary secretary = new Secretary("TinTin", 10, analyst);

        int counter = 0;
        if (!testNullRequestDescription(secretary)) {
            System.out.println("Null request description test failed!");
            counter++;
        }
        if (!testEmptyRequestDescription(secretary)) {
            System.out.println("Empty request description test failed!");
            counter++;
        }
        if (!testRequestApprovedSecretary(secretary)) {
            System.out.println("Request approved by secretary test failed!");
            counter++;
        }
        if (!testRequestApprovedAnalyst(secretary)) {
            System.out.println("Request approved by analyst test failed!");
            counter++;
        }
        if (!testRequestApprovedAssociate(secretary)) {
            System.out.println("Request approved by associate test failed!");
            counter++;
        }
        if (!testRequestApprovedDirector(secretary)) {
            System.out.println("Request approved by director test failed!");
            counter++;
        }
        if (!testRequestApprovedMD(secretary)) {
            System.out.println("Request approved by MD test failed!");
            counter++;
        }
        if (!testRequestRejectedMD(secretary)) {
            System.out.println("Request rejected by MD test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

