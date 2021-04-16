import React, {Component} from 'react';
import ImageGallery from 'react-image-gallery';

class ProductImage extends Component {

  state = {
    images: []
  }

  // get image info from props
  componentDidMount() {
    // determine whether the images exist
    // props.xxx.images && props.xxx.images.length > 0
    // create images[]
    // for each image, push its {original, thumbnail} into images[]
    if (this.props.images && this.props.images.length > 0) {
      let images = [];

      this.props.images && this.props.images.map(item => {
        images.push({
          original: `http://localhost:8080/api/images/${item.uuid}`,
          thumbnail: `http://localhost:8080/api/images/${item.uuid}`
        })
      })

      this.setState({
        images: images
      })
    }
  }

  render() {
    const { images } = this.state;
    return (
      <div >
        <ImageGallery items={images} />;
      </div>
    );
  }
}

export default ProductImage;
