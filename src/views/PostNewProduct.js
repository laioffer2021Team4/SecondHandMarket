import React, { Component }from "react";
import {
  Container,
  Row,
  Col,
  Button,
  Form,
  FormGroup,
  FormInput, FormSelect, FormTextarea
} from "shards-react";

import UploadService from "../services/upload-files.service";
import ProductService from "../services/product.service";
import withAuth from "../components/auth/withAuth.js"

class PostNewProduct extends Component {
  constructor(props) {
    super(props);
    this.selectFile = this.selectFile.bind(this);
    this.upload = this.upload.bind(this);
    this.cancel = this.cancel.bind(this);
    this.onChangeStreet = this.onChangeStreet.bind(this);
    this.onChangeCity = this.onChangeCity.bind(this);
    this.onChangeState = this.onChangeState.bind(this);
    this.onChangeZipcode = this.onChangeZipcode.bind(this);
    this.onChangeTitle = this.onChangeTitle.bind(this);
    this.onChangeDescription = this.onChangeDescription.bind(this);
    this.onChangePrice = this.onChangePrice.bind(this);
    this.onChangeCondition = this.onChangeCondition.bind(this);
    this.addProduct = this.addProduct.bind(this);

    this.state = {
      title: "",
      price: 0,
      description: "",
      condition: "",
      street: "",
      city: "",
      state: "",
      zipcode: "",
      selectedFiles: undefined,
      currentFile: undefined,
      progress: 0,
      message: "",
      fileInfos: [],
      uuids: [],
    };
  }


  componentDidMount() {
    UploadService.getFiles().then((response) => {
      this.setState({
        fileInfos: response.data,
      });
    });
  }

  selectFile(event) {
    this.setState({
      selectedFiles: event.target.files,
    });
  }

  upload() {
    let currentFile = this.state.selectedFiles[0];

    this.setState({
      progress: 0,
      currentFile: currentFile,
    });

    UploadService.upload(currentFile, (event) => {
      this.setState({
        progress: Math.round((100 * event.loaded) / event.total),
      });
    })
      .then((response) => {

        this.setState({
          message: response.data.message,
        });
        this.state.uuids.push(response.data.url);
        return UploadService.getFiles();
      })
      .then((files) => {
        this.setState({
          fileInfos: files.data,
        });
      })
      .catch(() => {
        this.setState({
          progress: 0,
          message: "Could not upload the file!",
          currentFile: undefined,
        });
      });

    this.setState({
      selectedFiles: undefined,
    });
  }

  cancel = e=> {
    e.preventDefault();
    UploadService.delete(this.state.uuids).then(
      () => {
        this.props.history.push("/myposts");
        window.location.reload();
      })
  }

  addProduct = e=>{
    e.preventDefault();
    ProductService.addProduct(this.state.title,
      this.state.street,
      this.state.city,
      this.state.state,
      this.state.zipcode,
      this.state.price,
      this.state.description,
      this.state.condition,
      this.state.uuids).then(

      () => {
        this.props.history.push("/myposts");
        window.location.reload();
      });
  }

  onChangeStreet(e) {
    this.setState({
      street: e.target.value
    });
  }
  onChangeCity(e) {
    this.setState({
      city: e.target.value
    });
  }
  onChangeState(e) {
    this.setState({
      state: e.target.value
    });
  }
  onChangeZipcode(e) {
    this.setState({
      zipcode: e.target.value
    });
  }

  onChangeTitle(e) {
    this.setState({
      title: e.target.value
    });
  }

  onChangePrice(e) {
    this.setState({
      price: e.target.value
    });
  }

  onChangeDescription(e) {
    this.setState({
      description: e.target.value
    });
  }

  onChangeCondition(e) {
    this.setState({
      condition: e.target.value
    });
  }

  render() {

    const {
      selectedFiles,
      currentFile,
      progress,
      message,
      fileInfos,
    } = this.state;

    return (
      <Container fluid className="main-content-container px-4 pb-4"
                 style={{display: "flex", justifyContent: "center"}}>
        <div style={{width: "700px"}}>
          <div className="page-header py-4">
            <h3 style={{textAlign: "center"}}>Post New Product</h3>
          </div>

          <Form>
            {/* post title */}
            <FormGroup>
              <label htmlFor="postTitle">Title</label>
              <FormInput id="postTitle" placeholder="Post Title" value={this.state.title} onChange={this.onChangeTitle}/>
            </FormGroup>
            {/* product price and condition */}
            <Row form>
              <Col md="6" className="form-group">
                <label htmlFor="prodPrice">Price</label>
                <FormInput
                  type="number"
                  pattern="^\d{0,9}(\.\d{0,2}){0,1}$"
                  id="prodPrice"
                  placeholder="Product Price"
                  value={this.state.price} onChange={this.onChangePrice}
                />
              </Col>

              <Col md="6" className="form-group">
                <label htmlFor="prodCondition">Condition</label>
                <FormSelect id="prodCondition"  value={this.state.condition} onChange={this.onChangeCondition}>
                  <option value="">-- Choose Condition Level --</option>
                  <option>Brand New</option>
                  <option>Open Box</option>
                  <option>Used</option>
                </FormSelect>
              </Col>
            </Row>
            {/* address */}
            <FormGroup>
              <label htmlFor="custAddress">Street</label>
              <FormInput id="custAddress" value={this.state.street} onChange={this.onChangeStreet}/>
            </FormGroup>
            {/* city state zipcode */}
            <Row form>
              <Col md="6" className="form-group">
                <label htmlFor="custCity">City</label>
                <FormInput id="custCity" value={this.state.city} onChange={this.onChangeCity}/>
              </Col>
              <Col md="4" className="form-group">
                <label htmlFor="custState">State</label>
                <FormSelect id="custState" value={this.state.state} onChange={this.onChangeState}>
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
                <label htmlFor="custZip">ZipCode</label>
                <FormInput id="custZip" value={this.state.zipcode} onChange={this.onChangeZipcode}/>
              </Col>
            </Row>
            {/* product Description */}
            <Row form>
              <Col md="12" className="form-group">
                <label htmlFor="prodDescription">Description</label>
                <FormTextarea id="prodDescription" rows="5" value={this.state.description} onChange={this.onChangeDescription}/>
              </Col>
            </Row>
            <Row>
              <Col md="6" className="form-group">
                <label htmlFor="imageUpload">Upload Image</label>
                {currentFile && (
                  <div className="progress">
                    <div
                      className="progress-bar progress-bar-info progress-bar-striped"
                      role="progressbar"
                      aria-valuenow={progress}
                      aria-valuemin="0"
                      aria-valuemax="100"
                      style={{ width: progress + "%" }}
                    >
                      {progress}%
                    </div>
                  </div>
                )}
                <label className="btn btn-default">
                  <input type="file" onChange={this.selectFile} />
                </label>

                <button
                  className="btn btn-success"
                  disabled={!selectedFiles}
                  onClick={this.upload}
                >
                  Upload
                </button>

                <div className="alert alert-light" role="alert">
                  {message}
                </div>

              </Col>
              <Col>
                <div className="form-group">
                  <label htmlFor="imageUpload">Uploaded Images</label>
                  <ul className="list-group list-group-flush">
                    {fileInfos &&
                    fileInfos.map((file, index) => (
                      <li className="list-group-item" key={index}>
                        <a href={file.url}>{file.name}</a>
                      </li>
                    ))}
                  </ul>
                </div>
              </Col>
            </Row>
            {/* post button */}
            <Row>
              <Col md="2">
                <Button type="submit" theme="danger" onClick={this.cancel}>Cancel</Button>
              </Col>
              <Col>
                <Button type="submit" theme="accent" onClick={this.addProduct}>Post Product</Button>
              </Col>
            </Row>
          </Form>

        </div>
      </Container>
    );
  }
}

export default  withAuth(PostNewProduct);
