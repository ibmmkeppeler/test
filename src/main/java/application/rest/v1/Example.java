package application.rest.v1;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;


@Path("v1/example")
public class Example {


    @GET
	@Produces("image/png")
	public Response example() {

    BufferedImage image = null;
    byte[] imageData = null;
    
    try {
         image = ImageIO.read(Example.class.getResource("/resources/images/icp-event_startseite-1.jpg"));
    } catch (IOException ioe) {
         ioe.printStackTrace();
    }

	try {
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	ImageIO.write(image, "png", baos);
    	imageData = baos.toByteArray();
	} catch (IOException ioe) {
         ioe.printStackTrace();
    }
    // uncomment line below to send non-streamed
    return Response.ok(imageData).build();

    // uncomment line below to send streamed
    // return Response.ok(new ByteArrayInputStream(imageData)).build();
    }

}
