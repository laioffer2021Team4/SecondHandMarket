import React from "react";
import {
  Container,
  Row,
  Col,
  Button,
  Form,
  FormGroup,
  FormInput, FormSelect, FormTextarea
} from "shards-react";
import CustomFileUpload
  from "../components/components-overview/CustomFileUpload";

const PostNewProduct = () => (
  <Container fluid className="main-content-container px-4 pb-4" style={{display:"flex", justifyContent:"center"}}>
    <div style={{width:"700px"}}>
      <div className="page-header py-4">
        <h3 style={{textAlign:"center"}}>Edit Post</h3>
      </div>

      <Form>
        {/* post title */}
        <FormGroup>
          <label htmlFor="postTitle">Title</label>
          <FormInput id="postTitle" placeholder="Post Title" />
        </FormGroup>
        {/* product price and condition */}
        <Row form>
          <Col md="6" className="form-group">
            <label htmlFor="prodPrice">Price</label>
            <FormInput
              id="prodPrice"
              placeholder="Product Price"
              onChange={() => {}}
            />
          </Col>

          <Col md="6" className="form-group">
            <label htmlFor="prodCondition">Condition</label>
            <FormSelect id="prodCondition">
              <option value="">-- Choose Condition Level --</option>
              <option>Brand New</option>
              <option>Open Box</option>
              <option>Used</option>
            </FormSelect>
          </Col>
        </Row>
        {/* address */}
        <FormGroup>
          <label htmlFor="custAddress">Address</label>
          <FormInput id="custAddress" placeholder="1234 Main St" />
        </FormGroup>
        {/* city state zipcode */}
        <Row form>
          <Col md="6" className="form-group">
            <label htmlFor="custCity">City</label>
            <FormInput id="custCity" />
          </Col>
          <Col md="4" className="form-group">
            <label htmlFor="custState">State</label>
            <FormSelect id="custState">
              <option value="">-- Choose State --</option>
              <option value="AL">Alabama</option>
              <option value="AK">Alaska</option>
              <option value="AZ">Arizona</option>
              <option value="AR">Arkansas</option>
              <option value="CA">California</option>
              <option value="CO">Colorado</option>
              <option value="CT">Connecticut</option>
              <option value="DE">Delaware</option>
              <option value="FL">Florida</option>
              <option value="GA">Georgia</option>
              <option value="HI">Hawaii</option>
              <option value="ID">Idaho</option>
              <option value="IL">Illinois</option>
              <option value="IN">Indiana</option>
              <option value="IA">Iowa</option>
              <option value="KS">Kansas</option>
              <option value="KY">Kentucky</option>
              <option value="LA">Louisiana</option>
              <option value="ME">Maine</option>
              <option value="MD">Maryland</option>
              <option value="MA">Massachusetts</option>
              <option value="MI">Michigan</option>
              <option value="MN">Minnesota</option>
              <option value="MS">Mississippi</option>
              <option value="MO">Missouri</option>
              <option value="MT">Montana</option>
              <option value="NE">Nebraska</option>
              <option value="NV">Nevada</option>
              <option value="NH">New Hampshire</option>
              <option value="NJ">New Jersey</option>
              <option value="NM">New Mexico</option>
              <option value="NY">New York</option>
              <option value="NC">North Carolina</option>
              <option value="ND">North Dakota</option>
              <option value="OH">Ohio</option>
              <option value="OK">Oklahoma</option>
              <option value="OR">Oregon</option>
              <option value="PA">Pennsylvania</option>
              <option value="RI">Rhode Island</option>
              <option value="SC">South Carolina</option>
              <option value="SD">South Dakota</option>
              <option value="TN">Tennessee</option>
              <option value="TX">Texas</option>
              <option value="UT">Utah</option>
              <option value="VT">Vermont</option>
              <option value="VA">Virginia</option>
              <option value="WA">Washington</option>
              <option value="WV">West Virginia</option>
              <option value="WI">Wisconsin</option>
              <option value="WY">Wyoming</option>
            </FormSelect>
          </Col>
          <Col md="2" className="form-group">
            <label htmlFor="custZip">Zip</label>
            <FormInput id="custZip" />
          </Col>
        </Row>
        {/* product Description */}
        <Row form>
          <Col md="12" className="form-group">
            <label htmlFor="prodDescription">Description</label>
            <FormTextarea id="prodDescription" rows="5" />
          </Col>
        </Row>
        <Row>
          <Col md="6" className="form-group">
            <label htmlFor="imageUpload">Upload Image</label>
            <CustomFileUpload />
          </Col>
        </Row>
        {/* post button */}
        <Row>
          <Col md="2">
            <Button type="submit" theme="danger">Cancel</Button>
          </Col>
          <Col>
            <Button type="submit" theme="accent">Post Product</Button>
          </Col>
        </Row>
      </Form>

    </div>
  </Container>
);

export default PostNewProduct;
